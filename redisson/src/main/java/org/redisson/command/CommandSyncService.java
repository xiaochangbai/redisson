/**
 * Copyright (c) 2013-2022 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.command;

import org.redisson.api.RFuture;
import org.redisson.client.codec.Codec;
import org.redisson.client.protocol.RedisCommand;
import org.redisson.connection.ConnectionManager;
import org.redisson.liveobject.core.RedissonObjectBuilder;

/**
 *
 * @author Nikita Koksharov
 *
 */
public class CommandSyncService extends CommandAsyncService implements CommandExecutor {

    public CommandSyncService(ConnectionManager connectionManager, RedissonObjectBuilder objectBuilder) {
        super(connectionManager, objectBuilder, RedissonObjectBuilder.ReferenceType.DEFAULT);
    }

    @Override
    public <T, R> R read(String key, RedisCommand<T> command, Object... params) {
        return read(key, connectionManager.getCodec(), command, params);
    }

    @Override
    public <T, R> R read(String key, Codec codec, RedisCommand<T> command, Object... params) {
        RFuture<R> res = readAsync(key, codec, command, params);
        return get(res);
    }

}
