/**
 * Copyright 2009-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.javacrumbs.codecamp.spring5;

import net.javacrumbs.codecamp.common.CsvFileLogger;
import net.javacrumbs.codecamp.common.InMemoryLogger;
import net.javacrumbs.codecamp.common.ReadableLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.util.List;

@Configuration
@PropertySource("app-config.properties")
public class LoggerConfiguration2 {

    @Bean
    public ReadableLogger fileLogger(@Value("${db.file}") File file) { // Type conversion
        return new CsvFileLogger(file);
    }

    @Bean
    public ReadableLogger inMemoryLogger() {
        return new InMemoryLogger();
    }

    @Bean
    public AggregateLogger aggregateLogger(List<ReadableLogger> loggers) {
        return new AggregateLogger(loggers);
    }
}
