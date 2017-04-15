/*
 * Copyright 2016 charl.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.atf.support.excepiton;

/**
 *
 * @author charl
 */
public class DataFieldValidateFailedException extends RuntimeException {

    public DataFieldValidateFailedException() {
        super();
    }

    public DataFieldValidateFailedException(String message) {
        super(message);
    }

    public DataFieldValidateFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFieldValidateFailedException(Throwable cause) {
        super(cause);
    }

}
