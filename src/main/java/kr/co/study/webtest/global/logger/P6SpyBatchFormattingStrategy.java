package kr.co.study.webtest.global.logger;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.P6SpyOptions;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import static org.hibernate.engine.jdbc.internal.FormatStyle.BASIC;
import static org.hibernate.engine.jdbc.internal.FormatStyle.DDL;

@Configuration
@Slf4j
public class P6SpyBatchFormattingStrategy implements MessageFormattingStrategy {

	private static final String BATCH_META_SQL_LOG_PREFIX = "[BATCH_META_SQL]";
	private static final String BUSINESS_SQL_LOG_PREFIX = "[BUSINESS_SQL]";

	@PostConstruct
	public void setLogMessageFormat() {
		P6SpyOptions.getActiveInstance().setLogMessageFormat(this.getClass().getName());
	}

	@Override
	public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared,
		String sql, String url) {
		sql = formatSql(category, sql);
		StringBuilder message = new StringBuilder("category: " + category + " ");
		message.append(sql).append(" Elapsed Time: ").append(elapsed).append("ms");
		return message.toString();
	}

	private String formatSql(String category, String sql) {
		if (sql == null || sql.trim().isBlank()) {
			return sql;
		}

		if (Category.STATEMENT.getName().equals(category)) {
			String tempSql = sql.trim();

			if (tempSql.startsWith("CREATE") || tempSql.startsWith("ALTER") || tempSql.startsWith("COMMENT")) {
				sql = DDL.getFormatter().format(tempSql);
			} else {
				sql = BASIC.getFormatter().format(tempSql);
			}

			if (sql.contains("BOOT3_BATCH_STEP") || sql.contains("BOOT3_BATCH_JOB")) {
				sql = String.format("%s: {%s \n}", BATCH_META_SQL_LOG_PREFIX, sql);
			} else {
				sql = String.format("%s: {%s \n}", BUSINESS_SQL_LOG_PREFIX, sql);
			}
		}

		return sql;
	}
}
