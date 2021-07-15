package top.codekiller.mall.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author codekiller
 * @date 2020/5/26 23:35
 * @Description MP配置类
 */
@Configuration
@EnableTransactionManagement
@MapperScan("top.codekiller.mall.mapper")
public class MpConfig {
        /**
         * 乐观锁插件
         * @return
         */
        @Bean
        public OptimisticLockerInterceptor optimisticLockerInterceptor() {
            return new OptimisticLockerInterceptor();
        }
}
