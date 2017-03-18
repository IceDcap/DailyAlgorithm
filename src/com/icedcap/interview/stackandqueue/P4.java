package com.icedcap.interview.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列
 */
public class P4 {
    class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    class Cat extends Pet {

        public Cat() {
            super("cat");
        }
    }

    class Dog extends Pet {

        public Dog() {
            super("dog");
        }
    }

    class PetEnterQueue {
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public long getCount() {
            return count;
        }

        public Pet getPet() {
            return pet;
        }

        public String getEnterPetType() {
            return this.pet.getType();
        }
    }

    class CatDogQueue {
        Queue<PetEnterQueue> dogQ;
        Queue<PetEnterQueue> catQ;
        private long count;
        public CatDogQueue() {
            dogQ = new LinkedList<>();
            catQ = new LinkedList<>();
            count = 0;
        }

        public void add(Pet pet) {
            if (pet.type.equals("dog")) {
                dogQ.add(new PetEnterQueue(pet, count++));
            }else if (pet.type.equals("cat")) {
                catQ.add(new PetEnterQueue(pet, count++));
            }else {
                throw new RuntimeException("error");
            }
        }

        public Pet pollAll() {
            if (!dogQ.isEmpty()&&!catQ.isEmpty()) {
                if (dogQ.peek().count< catQ.peek().count) {
                    return dogQ.poll().getPet();
                } else {
                    return catQ.poll().getPet();
                }
            } else if (!dogQ.isEmpty()) {
                return dogQ.poll().getPet();
            } else if (!catQ.isEmpty()) {
                return catQ.poll().getPet();
            }else {
                throw new RuntimeException("empty queue");
            }
        }

        public Dog pollDog() {
            if (isDogQueueEmpty()) {
                throw new RuntimeException("dog queue is empty");
            }
            return (Dog) dogQ.poll().getPet();
        }

        public Cat pollCat() {
            if (isCatQueueEmpty()) {
                throw new RuntimeException("dog queue is empty");
            }
            return (Cat) catQ.poll().getPet();
        }

        public boolean isEmpty() {
            return dogQ.isEmpty()&&catQ.isEmpty();
        }

        public boolean isDogQueueEmpty() {
            return dogQ.isEmpty();
        }

        public boolean isCatQueueEmpty() {
            return catQ.isEmpty();
        }
    }
}
