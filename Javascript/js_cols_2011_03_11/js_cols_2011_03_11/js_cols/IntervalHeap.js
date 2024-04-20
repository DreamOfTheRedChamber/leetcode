//Copyright Thomas Stjernegaard Jeppesen. All Rights Reserved.

//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at

//http://www.apache.org/licenses/LICENSE-2.0

//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS-IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.

js_cols.provide('js_cols.IntervalHeap');
/**
 * 
 *
 *
 * js_cols.IntervalHeap is a double-ended Priority Queue, based on a Binary Heap.
 * This allows deleteMin and deleteMax in at O(logn) running time, and also efficiently
 * keeps track of the current interval contained in the queue.
 * This IntervalHeap is addressable, i.e. a handle is returned when inserting an element.
 * The handles are used for efficient remove and change key operations, both in time O(logn).
 * Algorithms are adaptations of those in J. van Leeuwen and
 * D. Wood <I>Interval Heaps</I>.<p>
 * The big-O notation for all operations are below:
 * <pre>
 *   Method                 big-O
 * ----------------------------------------------------------------------------
 * - changeKey              O(logn)
 * - clear                  O(1)
 * - clone                  O(n)
 * - deleteMin              O(logn)
 * - deleteMax              O(logn)
 * - getKeys                O(n)
 * - getValues              O(n)
 * - insert                 O(logn)
 * - insertAll              O(n logn)
 * - max                    O(1)
 * - min                    O(1)
 * - remove                 O(logn)                  
 * </pre>
 *
 * @param {Function=} compare_func an optional compare function to compare the keys. This function should
 * take two values, a and b, and return x where:
 * <pre>
 *  x < 0 if a < b,
 *  x > 0 if a > b,
 *  x = 0 otherwise
 * </pre>
 * if not defined, a default compare function for <tt>numbers</tt> will be used
 * @constructor
 * @public
 */

js_cols.IntervalHeap = function(compare_func){

	this.heap = [];

	this.n = 0;
	
	this.count = 0;
	
	/**
	 * Comparison function used to compare values in the tree. This function should
	 * take two values, a and b, and return x where:
	 * <pre>
	 *  x < 0 if a < b,
	 *  x > 0 if a > b,
	 *  x = 0 otherwise
	 * </pre>
	 *
	 * @type {Function}
	 * @private
	 */
	this.compare = compare_func || this.default_compare;
	
	};
	
	/**
	 * Returns the number of key/value pairs in the Priorityqueue
	 * @return {number} 
	 * @public
	 */
	js_cols.IntervalHeap.prototype.getCount = function(){
	return this.count;
	};
	
	/**
	 * Removes all key/value pairs from the heap
	 * @public
	 */
	js_cols.IntervalHeap.prototype.clear = function(){
	this.heap = [];
	this.count =0;
	this.n = 0;
	};
	
	/**
	 * Returns true if theres zero key/ value pairs in the heap
	 * @return {boolean}
	 * @public
	 */
	js_cols.IntervalHeap.prototype.isEmpty = function(){
		return this.getCount() ==0;
	};
	
	/**
	 * Returns a shallow clone of this heap
	 * @return {js_cols.IntervalHeap}
	 * @public
	 */
	js_cols.IntervalHeap.prototype.clone = function(){
		var retval = new js_cols.IntervalHeap(this.compare);
		if (this.isEmpty()) return retval;
		var arr = [];
		var j = Math.floor(this.getCount()/2);
		for (var i =1; i<= j; i++){
			if(this.heap[i]){
			arr[i] = {
				"left": {},
				"right":{}
			};
			arr[i].left.key = this.heap[i].left.key;
			arr[i].left.value = this.heap[i].left.value;
			
			arr[i].right.key = this.heap[i].right.key;
			arr[i].right.value = this.heap[i].right.value;
			
		};
		};
		j++;
		
		if (this.heap[j]){
		arr[j] = {
				"left": {}			
			};
		arr[j].left.key = this.heap[j].left.key;
		arr[j].left.value = this.heap[j].left.value;
		}
		retval.heap = arr;
		retval.n = this.n;
		retval.count = this.count;
		return retval;
	};
	
	/**
	 * Returns an array with the keys of this heap.
	 * NOTICE: The returned array is unordered
	 * @return {Array}
	 * @public
	 */
	js_cols.IntervalHeap.prototype.getKeys = function(){
		var retval = []
		if (this.isEmpty()) return retval;
		var j = Math.floor(this.getCount()/2);
		for (var i =1; i<= j; i++){
			if(this.heap[i]){
			retval.push(this.heap[i].left.key);
			
			retval.push(this.heap[i].right.key);
			
		};
		};
		j++;
		
		if (this.heap[j]){
		retval.push(this.heap[j].left.key);
		}
		
		return retval;
	};
	
	/**
	 * Returns an array with the values of this heap.
	 * NOTICE: The returned array is unordered
	 * @return {Array}
	 * @public
	 */
	js_cols.IntervalHeap.prototype.getValues = function(){
		var retval = []
		if (this.isEmpty()) return retval;
		var j = Math.floor(this.getCount()/2);
		for (var i =1; i<= j; i++){
			if(this.heap[i]){
			retval.push(this.heap[i].left.value);
			
			retval.push(this.heap[i].right.value);
			
		};
		};
		j++;
		if (this.heap[j]){
		retval.push(this.heap[j].left.value);
		}
		
		return retval;
	};
	
	/**
	 * Inserts a collection of key/value pairs into the map
	 * If the collection has no notion of keys (i.e. an Array or Set) each element
	 * is inserted as both key and value (mapping to it self)
	 * @param {js_cols.Collection || Object || Array} col the collection to insert
	 * @public
	 */
	js_cols.IntervalHeap.prototype.insertAll = function(col){
		if (js_cols.typeOf(col) == "array"){
			for (var i = 0; i < col.length; i++){
				this.insert(col[i], col[i]);
			};
		}
		else if (js_cols.typeOf(col.forEach) == "function"){
			col.forEach(this.insertSwapped, this);
		}
		else if (js_cols.typeOf(col.getValues) == "function" && js_cols.typeOf(col.getKeys) == "function" ){
			var vals = col.getValues();
			var keys = col.getKeys();
			for (var i = 0; i < keys.length; i++){
				this.insert(keys[i], vals[i]);
			};
		}
		else if (js_cols.typeOf(col) == "object") {
			for (var key in col){
				this.insert(key, col[key]);
			}
		}
	};
	
	/*
	* Helpermethod for insertAll
	*
	* @param {*} value
	* @param {*} key
	* @private
	*/
	
	js_cols.IntervalHeap.prototype.insertSwapped = function(value, key){
		this.insert(key, value);
	};
	
	
	
	/**
	 * Returns the value associated with the minimum key of the queue
	 * @return {*} the value associated with the minimum key
	 * @public
	 */

	js_cols.IntervalHeap.prototype.min = function(){

		if (this.n > 0)
			return this.heap[1].left.value;
		else return null;
	};

	/**
	 * Returns the value associated with the maximum key of the queue
	 * @return {*} the value associated with the maximumkey
	 * @public
	 */
	js_cols.IntervalHeap.prototype.max = function(){

		if (this.n > 0 && this.heap[1].right) {
			return this.heap[1].right.value;
		}
		else if (this.n === 1){
			return this.heap[1].left.value;
		}
		else return null;
	};
	
	/**
	 * A default compare function
	 * @private
	 */
	js_cols.IntervalHeap.prototype.default_compare = function (a,b) {
		if (a < b) return -1;
		else if (b < a) return 1;
		else return 0;
	};
	

	/**
	 * Inserts a value prioritized after the supplied key
	 * @param {*} k the priority key
	 * @param {*} v the value to insert
	 * @return {js_cols.IntervalHeap.Handle} a Priority Queue Handle, used for later changeKey or remove operations
	 * @public
	 */
	js_cols.IntervalHeap.prototype.insert = function(k, v){ 

		
		var handle = new js_cols.IntervalHeap.Handle(k, v, this.n, this);

		// if the last node "n" is full, create new node and insert handle at its left

		if (this.n>0){
			if (this.heap[this.n].right == null){
				var temp = this.heap[this.n].left;
				if (this.compare(temp.key, handle.key) <= 0){
					this.heap[this.n].right = handle;
				}
				else{
					this.heap[this.n].left = handle;
					this.heap[this.n].right = temp;
				}
			}
			else {
				this.n++;
				handle.index = this.n;
				this.heap[this.n] = {};
				this.heap[this.n].left = handle;

			}	


		}
		// if n=0
		else {
			this.n++;

			handle.index = this.n;
			this.heap[this.n] = {};
			this.heap[this.n].left = handle;

		}
		var m = Math.floor(this.n / 2);

		if (this.n>1){
			if(this.compare(this.heap[m].left.key, this.heap[this.n].left.key) > 0) this.siftUpMin(this.n);

			else if (this.heap[this.n].right != null && this.compare(this.heap[m].right.key, this.heap[this.n].right.key) < 0) this.siftUpMax(this.n);

			else if (this.compare(this.heap[m].right.key, this.heap[this.n].left.key) < 0) this.siftUpMax(this.n);
		}

		this.count++;
		return handle;
	};

	/**
	 * Removes and returns the value associated with the minimum key in the queue
	 * @return {*} the value associated with the minimum key in the queue
	 * @public
	 */
	js_cols.IntervalHeap.prototype.deleteMin = function (){

		if (this.n <= 0) return null; 
		var result = this.heap[1].left.value;
		this.heap[1].left.container = undefined; // invalidate handle
		this.heap[this.n].left.index = 1;
		this.heap[1].left = this.heap[this.n].left;

		if (this.heap[this.n].right == null) {
			this.heap.pop();
			this.n --;

		}
		else {
			this.heap[this.n].left = this.heap[this.n].right;
			this.heap[this.n].right = null;
		}
		this.siftDownMin(1);
		this.count--;
		return result;
	};

	/**
	 * Removes and returns the value associated with the maximum key in the queue
	 * @return {*} the value associated with the maximum key in the queue
	 * @public
	 */
	js_cols.IntervalHeap.prototype.deleteMax = function (){

		if (this.n <= 0) return null; 
		
		if (this.heap[1].right !=null){ // if heap[1].right is not null 

			var result = this.heap[1].right.value;
			this.heap[1].right.container = null; // invalidate handle

			if (this.heap[this.n].right != null){
				this.heap[this.n].right.index = 1;
				this.heap[1].right = this.heap[this.n].right;
				this.heap[this.n].right = null;
			}
			else{
				this.heap[this.n].left.index = 1;
				this.heap[1].right = this.heap[this.n].left;
				this.heap.pop();
				this.n--;
			}

			this.siftDownMax(1);
			this.count--;
			return result;
		}
		// if heap[1].right is null (only one element in queue) deletemin instead
		else return this.deleteMin();
	};

	/**
	 * Changes the key for the value associated with the supplied handle
	 * @param {js_cols.IntervalHeap.Handle} handle the handle to use for location of the value
	 * @param {*} newKey the new key to associate with the value
	 * @return {boolean} true if the handle was valid for this heap, and the key was successfully changed, otherwise false
	 * @public
	 */
	js_cols.IntervalHeap.prototype.changeKey = function(handle, newKey){

		if (!this.containedInThisQueue(handle)) 
			return false;

		var idx = handle.index;
		var j = Math.floor(idx / 2);

		if (this.heap[idx].left === handle) {

			this.heap[idx].left.key = newKey;

		}

		else {

			this.heap[idx].right.key = newKey;

		}

		if (idx < this.n || this.heap[idx].right) {
			if (this.compare(this.heap[idx].left.key, this.heap[idx].right.key) > 0) {

				this.swapSides(idx);
			}
			
			if (idx > 1 && this.compare(this.heap[j].left.key, this.heap[idx].left.key) > 0) 
				this.siftUpMin(idx);
			else 
				this.siftDownMin(idx);
			if (idx > 1 && this.compare(this.heap[j].right.key, this.heap[idx].right.key) < 0) 
				this.siftUpMax(idx);
			else 
				this.siftDownMax(idx);

		}

		else {
			if (idx > 1 && this.compare(this.heap[j].left.key, this.heap[idx].left.key) > 0) 
				this.siftUpMin(idx);
			else 
				if (idx > 1 && this.compare(this.heap[j].right.key, this.heap[idx].left.key) < 0) 
					this.siftUpMax(idx);

		}
		return true;
	};



	/**
	 * Removes the value associated with the supplied handle
	 * @param {js_cols.IntervalHeap.Handle} handle the handle to use for location of the value
	 * @return {boolean} true if the handle was valid for this heap, and the value was successfully removed, otherwise false
	 * @public
	 */
	js_cols.IntervalHeap.prototype.remove = function (handle){

		if (! this.containedInThisQueue(handle)) return false;
		var idx = handle.index;
		var isLeft = false;
		if (this.heap[idx].left == handle) isLeft =true;
		
		if (isLeft){
			this.heap[idx].left.container = null; // invalidate handle
			this.heap[idx].left = this.heap[this.n].left;
			this.heap[idx].left.index = idx;
			this.heap[this.n].left =null;	
			this.siftDownMin(idx);
			if (this.heap[this.n].right==null){
				this.heap.pop();
				this.n--;
			}
			else{
				this.swapSides(this.n);	
			}
		}
		else{
			if (this.heap[this.n].right !=null){
				this.heap[idx].right.container = null; // invalidate handle
				this.heap[idx].right = this.heap[this.n].right;
				this.heap[idx].right.index = idx;
				this.heap[this.n].right =null;
				this.siftDownMax(idx);
			}
			else{
				this.heap[idx].right.container = null; // invalidate handle
				this.heap[idx].right = this.heap[this.n].left;
				this.heap[idx].right.index = idx;
				this.heap[this.n] =null;
				this.n--;
				this.siftDownMax(idx);
			}

		}
		this.count--;
		return true;
	};

	/**
	 * A recursive helper function to reestablish heap order
	 * @param {Integer} i the index
	 * @private
	 */
	js_cols.IntervalHeap.prototype.siftUpMin = function(i){

		var j = Math.floor(i / 2); 
		if (i == 1 || this.compare(this.heap[j].left.key, this.heap[i].left.key) <= 0) return;

		this.swapLeft(j,i);
		this.siftUpMin(j);
	};
	
	/**
	 * A recursive helper function to reestablish heap order
	 * @param {Integer} i the index
	 * @private
	 */
	js_cols.IntervalHeap.prototype.siftDownMin = function (i){

		if (2*i<= this.n){

			if (2*i+1 > this.n ||!this.heap[2*i+1].left ||this.compare(this.heap[2*i].left.key, this.heap[2*i+1].left.key) <= 0) var m= 2*i;
			else var m = 2*i+1;
			if (this.compare(this.heap[i].left.key, this.heap[m].left.key) > 0){

				this.swapLeft(i,m);
				if (this.heap[m].right && this.compare(this.heap[m].left.key, this.heap[m].right.key) > 0){
					this.swapSides(m);
				}
				this.siftDownMin(m);
			}

		}
	};
	
	/**
	 * A recursive helper function to reestablish heap order
	 * @param {Integer} i the index
	 * @private
	 */
	js_cols.IntervalHeap.prototype.siftUpMax = function(i){

		var j = Math.floor(i / 2);
		if (i < this.n || this.heap[this.n].right != null) {
			if (i == 1 || this.compare(this.heap[j].right.key, this.heap[i].right.key) >= 0) 
				return;

			this.swapRight(j, i);
			this.siftUpMax(j);
		}
		else  {
			if (i == 1 || this.compare(this.heap[j].right.key, this.heap[i].left.key) >= 0) return;

			this.heap[j].right.index = i; //change indexes in handles
			this.heap[i].left.index = j;
			var temp = this.heap[j].right; 
			this.heap[j].right = this.heap[i].left;
			this.heap[i].left = temp;
			this.siftUpMax(j);
		}
	};
	
	/**
	 * A recursive helper function reestablish heap order
	 * @param {Integer} i the index
	 * @private
	 */
	js_cols.IntervalHeap.prototype.siftDownMax = function (i){

		if (2*i<= this.n){

			if (2*i+1 > this.n || this.heap[2*i+1].right ==null || this.compare(this.heap[2*i].right.key, this.heap[2*i+1].right.key) > 0) var m= 2*i;
			else var m = 2*i+1;
			if (this.heap[m].right != null && this.compare(this.heap[i].right.key, this.heap[m].right.key) < 0){

				this.swapRight(i,m);

				if (this.compare(this.heap[m].left.key, this.heap[m].right.key) > 0){
					this.swapSides(m);
				}
				this.siftDownMax(m);
			}

		}
	};
	/**
	 * A helper function to swap two elements in the
	 * left side (minimum side) of the heap
	 * @param {Integer} i1 the first elements index
	 * @param {Integer} i2 the second elements index
	 * @private
	 */
	js_cols.IntervalHeap.prototype.swapLeft = function(i1, i2){

		this.heap[i1].left.index = i2;
		this.heap[i2].left.index = i1;
		var temp = this.heap[i1].left; 
		this.heap[i1].left = this.heap[i2].left;
		this.heap[i2].left = temp;
	};
	
	/**
	 * A helper function to swap two elements in the
	 * right side (maximum side) of the heap
	 * @param {Integer} i1 the first elements index
	 * @param {Integer} i2 the second elements index
	 * @private
	 */
	js_cols.IntervalHeap.prototype.swapRight = function(i1, i2){

		this.heap[i1].right.index = i2;
		this.heap[i2].right.index = i1;
		var temp = this.heap[i1].right; 
		this.heap[i1].right = this.heap[i2].right;
		this.heap[i2].right = temp;
	};
	/**
	 * A helper function to swap sides in a heap node
	 * @param {Integer} index the index where the elements should be swapped
	 * @private
	 */
	js_cols.IntervalHeap.prototype.swapSides = function(index){

		var temp = this.heap[index].left;
		this.heap[index].left = this.heap[index].right;
		this.heap[index].right = temp;
	};
	
	/**
	 * Function to check that a given handle is contained in this queue
	 * @param {js_cols.IntervalHeap.Handle} hdl the handle to check
	 * @private
	 */
	js_cols.IntervalHeap.prototype.containedInThisQueue = function(hdl){

		if (hdl.container === this) 
			return true;
		else 
			return false;
	};


	/**
	 * A handle used to locate a given element in the heap to obtain O(logn) running time
	 * for changeKey and remove. Handles are returned when inserting a key/value pair into the heap.
	 * @param {*} k the priority key
	 * @param {*} v the value to insert
	 * @param {Integer} i the index in the heap
	 * @param {js_cols.IntervalHeap} c the heap containing the element referenced by this handle
	 * @constructor
	 * @public
	 */
js_cols.IntervalHeap.Handle = function(k,v,i,c){
this.key = k;
this.value = v;
this.index = i;
this.container = c;

};