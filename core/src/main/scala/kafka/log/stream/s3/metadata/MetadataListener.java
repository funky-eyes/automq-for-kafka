/*
 * Copyright 2024, AutoMQ CO.,LTD.
 *
 * Use of this software is governed by the Business Source License
 * included in the file BSL.md
 *
 * As of the Change Date specified in that file, in accordance with
 * the Business Source License, use of this software will be governed
 * by the Apache License, Version 2.0
 */

package kafka.log.stream.s3.metadata;

import org.apache.kafka.image.MetadataDelta;
import org.apache.kafka.image.MetadataImage;

public interface MetadataListener {

    void onChange(MetadataDelta delta, MetadataImage image);
}
