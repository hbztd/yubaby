package com.example.yubaby.config;

import com.mongodb.Mongo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * Description:
 * Author: Po
 * Date: 2019/4/30 18:22
 **/
@Configuration
public class MongoConfig {
    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory, MongoMappingContext context, BeanFactory beanFactory) {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(dbRefResolver, context);
        try {
//            **********bug***********
//            此处要写具体的实现 MongoCustomConversion 当引入redis时存在两个实现 注入失败
//            org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'org.springframework.data.convert.CustomConversions'
//            available: expected single matching bean but found 2: mongoCustomConversions,redisCustomConversions
            mappingMongoConverter.setCustomConversions(beanFactory.getBean(MongoCustomConversions.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return mappingMongoConverter;
    }
}