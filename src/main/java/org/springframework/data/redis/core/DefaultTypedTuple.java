/*
 * Copyright 2011 the original author or authors.
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
package org.springframework.data.redis.core;

import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

/**
 * Default implementation of TypedTuple.
 * 
 * @author Costin Leau
 */
class DefaultTypedTuple<V> implements TypedTuple<V> {

	private final Double score;
	private final V value;

	/**
	 * Constructs a new <code>DefaultTypedTuple</code> instance.
	 *
	 * @param value
	 * @param score
	 */
	public DefaultTypedTuple(V value, Double score) {
		this.score = score;
		this.value = value;
	}

	@Override
	public Double getScore() {
		return score;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DefaultTypedTuple))
			return false;
		DefaultTypedTuple other = (DefaultTypedTuple) obj;
		if (score == null) {
			if (other.score != null)
				return false;
		}
		else if (!score.equals(other.score))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		}
		else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public int compareTo(Double o) {
		Double d = (score == null ? Double.valueOf(0) : score);
		Double a = (o == null ? Double.valueOf(0) : o);
		return d.compareTo(a);
	}
}