/**   
 * @Description: 
 * @author huqinghua
 * @date 2020年11月10日 上午11:26:05 
 * @version V1.0   
 */

package com.github.hqh.mgm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ：huqinghua
 * @description：
 */
@SpringBootApplication(scanBasePackages = {"com.github.hqh.mgm"})
@EntityScan("com.github.hqh.mgm.persistence")
@EnableJpaRepositories(basePackages = {"com.github.hqh.mgm.persistence"})
public class MgmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MgmApplication.class, args);
    }

}
