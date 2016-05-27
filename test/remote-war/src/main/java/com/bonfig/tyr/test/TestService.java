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

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Random;

/**
 * TestService
 *
 * @author Dipl.-Ing. Robert C. Bonfig
 */
@Stateless
@Remote
@Path("/test")
@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
public class TestService {

    private Random random = new Random();

    @GET
    public Result test(@QueryParam("t") @DefaultValue("100") long time,
                       @QueryParam("s") @DefaultValue("10") long deviation) {
        if (time <= 0) {
            throw new IllegalArgumentException("Time must be positive");
        }
        if (deviation <= 0) {
            throw new IllegalArgumentException("Deviation must be positive");
        }

        long t0 = System.currentTimeMillis();
        long dt = Math.round(random.nextGaussian() * (double) deviation + (double) time);
        if (dt > 0) {
            try {
                Thread.sleep(dt);
            } catch (InterruptedException e) {
                // fall through
            }
        }
        long t1 = System.currentTimeMillis();
        return new Result(t0, t1 - t0);
    }

}
