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
js_cols.provide('js_cols.Stack');

/**
 * 
 *
 *
 * js_cols.Stack provides the implementation of a Stack based on a doubly Linked List. The list is circular,
 * keeping a dummy element (<i>"sentinel"</i>) .<p>
 * @see js_cols.LinkedList
 *
 * The big-O notation for all operations are below:
 * <pre>
 *   Method                 big-O
 * ----------------------------------------------------------------------------
 * - push                    O(1)
 * - pop                     O(1)
 * - peek                    O(1)
 * - isEmpty                 O(1)
 * </pre>
 *
 * @constructor
 * @extends js_cols.LinkedList
 */

js_cols.Stack = function(){

js_cols.LinkedList.call(this);

};

js_cols.inherits(js_cols.Stack, js_cols.LinkedList);

/**
 * Puts the specified element on this stack.
 * @param {*} element The element to be added to the stack.
 */
js_cols.Stack.prototype.push = function (element){

this.addFirst(element);
};
/**
 * Retrieves and removes the head of this stack.
 * @return {*} The element at the head of this queue. Returns undefined if the
 *     queue is empty.
 */
js_cols.Stack.prototype.pop = function(){

return this.removeFirst();

};

/**
 * Retrieves but does not remove the head of this stack.
 * @return {*} The element at the head of this stack. Returns null if the
 *     stack is empty.
 */
js_cols.Stack.prototype.peek =  function(){

return this.getFirst();

};


/**
	 * Removes a given element from the stack, if it is contained
	 * @param {*} o the element to remove
	 * @return {Boolean} wheter the object was removed;
	 * @public
	 */	
js_cols.Stack.prototype.remove = function(o){
		return this.removeObject(o);
	};



