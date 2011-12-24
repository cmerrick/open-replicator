/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.code.or.binlog.impl.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.code.or.binlog.BinlogEventV4Header;
import com.google.code.or.binlog.BinlogParserContext;
import com.google.code.or.binlog.BinlogRowEventFilter;
import com.google.code.or.binlog.impl.event.TableMapEvent;

/**
 * 
 * @author Jingqi Xu
 */
public class BinlogRowEventFilterImpl implements BinlogRowEventFilter {
	//
	private static final Logger LOGGER = LoggerFactory.getLogger(BinlogRowEventFilterImpl.class);
	
	//
	private boolean verbose = true;
	
	/**
	 * 
	 */
	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}
	
	/**
	 * 
	 */
	public boolean accepts(BinlogEventV4Header header, BinlogParserContext context, TableMapEvent event) {
		//
		if(event == null) {
			if(isVerbose() && LOGGER.isWarnEnabled()) {
				LOGGER.warn("failed to find TableMapEvent, header: {}", header);
			}
			return false;
		}
		
		//
		return true;
	}
}
