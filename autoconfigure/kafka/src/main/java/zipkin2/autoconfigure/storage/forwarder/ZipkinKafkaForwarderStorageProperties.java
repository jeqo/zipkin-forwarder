/*
 * Copyright 2019 Jorge Esteban Quilcate Otoya
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package zipkin2.autoconfigure.storage.forwarder;

import java.io.Serializable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import zipkin2.codec.Encoding;
import zipkin2.storage.StorageComponent;
import zipkin2.storage.forwarder.ZipkinKafkaForwarderStorage;

@ConfigurationProperties("zipkin.storage.kafka-forwarder")
public class ZipkinKafkaForwarderStorageProperties implements Serializable {
  private static final long serialVersionUID = 0L;

  private String bootstrapServers;

  private String topic = "zipkin";

  private String encoding = Encoding.JSON.name();

  public String getBootstrapServers() {
    return bootstrapServers;
  }

  public void setBootstrapServers(String bootstrapServers) {
    this.bootstrapServers = bootstrapServers;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getEncoding() {
    return encoding;
  }

  public void setEncoding(String encoding) {
    this.encoding = encoding;
  }

  StorageComponent.Builder toBuilder() {
    return ZipkinKafkaForwarderStorage.newBuilder()
            .bootstrapServers(bootstrapServers)
            .topic(topic)
            .encoding(encoding);
  }
}