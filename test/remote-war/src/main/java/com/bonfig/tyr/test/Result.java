/*
 * Copyright 2016 Bonfig GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bonfig.tyr.test;

/**
 * Result
 *
 * @author Dipl.-Ing. Robert C. Bonfig
 */
public class Result {

    private final long startTime;
    private final long time;

    public Result(final long startTime, final long time) {
        this.startTime = startTime;
        this.time = time;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getTime() {
        return time;
    }

}
