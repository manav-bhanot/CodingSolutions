package com.quantcast;

import java.util.*;

/*
 
1. Build a key/textValue (KV) store with transactions
 
KV store has following operations:
 
Operations:
 
add( K key, V textValue) : void , maps the key to the textValue, if key already present replaces with the current textValue 
getValue(key) : V, returns the textValue attached to the key
getKey(v textValue) K[], return all the keys which is associated with the given textValue
delete(key): void, delete the key if present, else do nothing
begin(): void, begin a transaction
rollback(): void, rollback the previous updates from the recent begin() statement
commit(): void, commit the current changes to the kvStore
 
Constraints: Operations add, getValue, delete, getKey should be constant time
Example operations:
 
KVStore kvStore = new KVStore()
 
1)
 
kvStore .add(k1, v1)
Current KV Object State:
{k1: v1}
 
2)
 
kvStore .add(k2, v2)
Current KV Object State:
{
  k1:v1
  k2:v2
}
 
3)
 
kvStore .begin()
kvStore .add(k1, v3)
Current KV Object State:
{k1:v3
 k2:v2
}
 
4)
kvStore .add(k1, v4)
Current KV Object State:
{k1: v4
 k2: v2}
 
5)
kvStore .rollback()
Current KV Object State:
{k1:v3
 k2:v2
 }
 
6)
kvStore .commit()
Current KV Object State:
{k1:v3
  k2:v2}
 
7)
kvStore.rollback() - No operation , has effect only within a transaction
Current KV Object State:
{k1: v3
 k2: v2}
 
8)
kvStore .begin()
kvStore .add(k3, v3)
 
Current KV Object State:
{k1:v3
  k2:v2
  k3:v3
 }
 
9)
kvStore .rollback()
Current KV Object State:
{
 k1:v3
 k2:v2
}
 
10)
kvStore .commit()
Current KV Object State:
{k1: v3
 k2: v2}
 
 
 */

public class KVStore extends HashMap<String, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isTransactionInProgress;

	Map<String, List<String>> map;

	// Stores the sequence in which keys are added
	Stack<String> orderedKeys;

	public KVStore() {
		map = new HashMap<String, List<String>>();
		orderedKeys = new Stack<String>();
	}

	// maps the key to the textValue, if key already present replaces with the current
	// textValue
	public void add(String key, String value) {

		if (this.isTransactionInProgress) {
			orderedKeys.push(key);

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(value);
		} else {
			this.put(key, value);
		}

	}

	// returns the textValue attached to the key
	public String getValue(String key) {

		String value = "";

		if (isTransactionInProgress && this.map.containsKey(key)) {
			int len = this.map.get(key).size();
			if (len > 0) {
				value = this.map.get(key).get(len - 1);
			}
		} else {
			value = this.get(key);
		}
		
		return value;
	}

	// return all the keys which is associated with the given textValue
	public List<String> getKey(String value) {

		List<String> keys = new ArrayList<String>();

		/**
		* 
		*/

		if (this.isTransactionInProgress) {

			// first traverse the in-memory map
			for (String key : this.map.keySet()) {
				int len = this.map.get(key).size();
				if (this.map.get(key).get(len - 1).equalsIgnoreCase(value)) {
					keys.add(key);
				}
			}
		}

		// now traverse the last committed map
		for (String key : this.keySet()) {
			if (this.get(key).equalsIgnoreCase(value) && !this.map.containsKey(key)) {
				keys.add(key);
			}
		}

		return keys;

	}

	// delete the key if present, else do nothing
	public void delete(String key) {

	}

	// begin a transaction
	public void begin() {
		this.isTransactionInProgress = true;
	}

	// rollback the previous updates from the recent begin() statement
	public void rollback() {

		if (!this.orderedKeys.isEmpty()) {
			String key = orderedKeys.pop();

			int len = this.map.get(key).size();
			this.map.get(key).remove(len - 1);

			if (this.map.get(key).isEmpty()) {
				this.map.remove(key, this.map.get(key));
			}
		}
	}

	// commit the current changes to the kvStore
	public void commit() {

		if (!this.map.isEmpty()) {

			// Traverse through the keyset
			// And save the k,v pairs in KVStore

			for (String key : this.map.keySet()) {
				int len = this.map.get(key).size();
				this.put(key, this.map.get(key).get(len - 1));
			}
			this.map.clear();
		}
		// end the transaction
		this.isTransactionInProgress = false;
	}

}
