# lrucache

[![Build Status](https://travis-ci.org/drish/lrucache.svg?branch=master)](https://travis-ci.org/drish/lrucache)

A Simple java implementation of a LRU Cache, it's backed by a doubly linked list and a hash map for O(1) operations.


### Usage

```java
// a cache with 5000 objects capacity;
LRUCache cache = new LRUCache(5000);
int id = 4; // some id
Guitar gibson = new Guitar();

cache.addObject(id, gibson);

cache.getMostAccessedObject(); // gibson
cache.getObject(id); // gibson
```