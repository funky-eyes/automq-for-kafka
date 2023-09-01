/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kafka.log.s3;

import kafka.log.s3.cache.ReadDataBlock;
import kafka.log.s3.model.StreamRecordBatch;

import java.util.concurrent.CompletableFuture;

/**
 * Write ahead log for server.
 */
public interface Storage {

    /**
     * Append stream record.
     *
     * @param streamRecord {@link StreamRecordBatch}
     */
    CompletableFuture<Void> append(StreamRecordBatch streamRecord);

    CompletableFuture<ReadDataBlock> read(long streamId, long startOffset, long endOffset, int maxBytes);

    /**
     * Force stream record in WAL upload to s3
     */
    CompletableFuture<Void> forceUpload(long streamId);

    void close();
}
