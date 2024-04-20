// Copyright 2010 Thomas Stjernegaard Jeppesen. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS-IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

js_cols.require('js_cols.LinkedList');
js_cols.provide('js_cols.Queue');
/**
 * 
 *
 *
 * js_cols.Queue provides the implementation of a Queue based on a doubly Linked List. The list is circular,
 * keeping a dummy element (<i>"sentinel"</i>) .<p>
 * @see js_cols.LinkedList
 *
 * The big-O notation for all operations are below:
 * <pre>
 *   Method                 big-O
 * ----------------------------------------------------------------------------
 * - enqueue                 O(1)
 * - dequeue                 O(1)
 * - peek                    O(1)
 * - isEmpty                 O(1)
 * - remove                  O(n)
 * </pre>
 *
 * @constructor
 * @extends js_cols.LinkedList
 */

js_cols.Queue = function(){

js_cols.LinkedList.call(this);

};

js_cols.inherits(js_cols.Queue, js_cols.LinkedList);

/**
 * Puts the specified element on this queue.
 * @param {*} element The element to be added to the queue.
 */
js_cols.Queue.prototype.enqueue = function (element){

this.addLast(element);
};
/**
 * Retrieves and removes the head of this queue.
 * @return {*} The element at the head of this queue. Returns undefined if the
 *     queue is empty.
 */
js_cols.Queue.prototype.dequeue = function(){

return this.removeFirst();

};

/**
 * Retrieves but does not remove the head of this queue.
 * @return {*} The element at the head of this queue. Returns null if the
 *     queue is empty.
 */
js_cols.Queue.prototype.peek = function(){

return this.getFirst();

};


/**
	 * Removes a given element from the queue, if it is contained
	 * @param {*} o the element to remove
	 * @return {Boolean} wheter the object was removed;
	 * @public
	 */	
	js_cols.Queue.prototype.remove = function(o){
		return this.removeObject(o);
	};




