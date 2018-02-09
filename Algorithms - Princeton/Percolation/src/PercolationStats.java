See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY

Compilation:  PASSED (0 errors, 6 warnings)
API:          PASSED

Findbugs:     FAILED (1 warning)
PMD:          PASSED
Checkstyle:   FAILED (0 errors, 26 warnings)

Correctness:  13/43 tests passed
Memory:       22/33 tests passed
Timing:       45/136 tests passed

Aggregate score: 41.42%
[Compilation: 5%, API: 5%, Findbugs: 0%, PMD: 0%, Checkstyle: 0%, Correctness: 60%, Memory: 10%, Timing: 20%]

ASSESSMENT DETAILS

The following files were submitted:
----------------------------------
4.7K Feb  6 03:43 Deque.java
 850 Feb  6 03:43 Permutation.java
3.4K Feb  6 03:43 RandomizedQueue.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac Deque.java
*-----------------------------------------------------------
Deque.java:29: warning: [unchecked] unchecked cast
        s = (Item[]) new Object[size];
                     ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class Deque
Deque.java:53: warning: [unchecked] unchecked cast
            Item[] copy = (Item[]) new Object[s.length*2]; 
                                   ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class Deque
Deque.java:83: warning: [unchecked] unchecked cast
            Item[] copy = (Item[]) new Object[s.length*2]; 
                                   ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class Deque
Deque.java:129: warning: [unchecked] unchecked cast
            Item[] copy = (Item[]) new Object[s.length/2]; 
                                   ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class Deque
4 warnings

% javac RandomizedQueue.java
*-----------------------------------------------------------
RandomizedQueue.java:26: warning: [unchecked] unchecked cast
        s = (Item[]) new Object[size];
                     ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class RandomizedQueue
RandomizedQueue.java:99: warning: [unchecked] unchecked cast
        Item[] copy = (Item[]) new Object[length];
                               ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class RandomizedQueue
2 warnings

% javac Permutation.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Deque:

RandomizedQueue:

Permutation:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% findbugs *.class
*-----------------------------------------------------------
H C ICAST_INT_CAST_TO_DOUBLE_PASSED_TO_CEIL ICAST: Casts an integral value to 'double' and then passed to 'Math.ceil().'  At Deque.java:[line 130]
Warnings generated: 1


================================================================


% pmd .
*-----------------------------------------------------------
Deque.java:21: Can you replace the instance (or static) variable 'size' with a local variable? [SingularField]
Deque.java:21: The private instance (or static) variable 'size' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
Deque.java:156: Avoid using assignment statements in expressions; this can make code harder to read. [AssignmentInOperand]
Deque.java:171: The method body is empty. If this is your intent, document it with a comment. [UncommentedEmptyMethodBody]
RandomizedQueue.java:19: Can you replace the instance (or static) variable 'size' with a local variable? [SingularField]
RandomizedQueue.java:19: The private instance (or static) variable 'size' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
RandomizedQueue.java:118: Avoid using assignment statements in expressions; this can make code harder to read. [AssignmentInOperand]
PMD ends with 7 warnings.


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] Deque.java:15:51: '>' is followed by an illegal character. [GenericWhitespace]
[WARN] Deque.java:15:51: '{' is not preceded with whitespace. [WhitespaceAround]
[WARN] Deque.java:17:27: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Deque.java:18:27: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Deque.java:19:29: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Deque.java:20:17: The instance variable 'N' must start with a lowercase letter and use camelCase. [MemberName]
[WARN] Deque.java:20:27: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Deque.java:21:27: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Deque.java:25:11: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Deque.java:27:22: Inner assignments should be avoided. [InnerAssignment]
[WARN] Deque.java:52:15: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Deque.java:54:34: Typecast is not followed by whitespace. [WhitespaceAfter]
[WARN] Deque.java:55:15: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Deque.java:82:15: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Deque.java:84:34: Typecast is not followed by whitespace. [WhitespaceAfter]
[WARN] Deque.java:85:15: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] Deque.java:127:18: The method 'SmallerArray' must start with a lowercase letter and use camelCase. [MethodName]
[WARN] RandomizedQueue.java:17:29: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] RandomizedQueue.java:18:17: The instance variable 'N' must start with a lowercase letter and use camelCase. [MemberName]
[WARN] RandomizedQueue.java:18:27: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] RandomizedQueue.java:19:27: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] RandomizedQueue.java:23:11: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] RandomizedQueue.java:86:18: The method 'SmallerArray' must start with a lowercase letter and use camelCase. [MethodName]
[WARN] RandomizedQueue.java:97:18: The method 'ResizeArray' must start with a lowercase letter and use camelCase. [MethodName]
[WARN] RandomizedQueue.java:98:11: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
[WARN] RandomizedQueue.java:139:11: '//' or '/*' is not followed by whitespace. [WhitespaceAfter]
Checkstyle ends with 0 errors and 26 warnings.

% custom checkstyle checks for Deque.java
*-----------------------------------------------------------

% custom checkstyle checks for RandomizedQueue.java
*-----------------------------------------------------------

% custom checkstyle checks for Permutation.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Deque
*-----------------------------------------------------------
Running 16 total tests.

Tests 1-6 make random calls to addFirst(), addLast(), removeFirst(),
removeLast(), isEmpty(), and size(). The probabilities of each
operation are (p1, p2, p3, p4, p5, p6), respectively.

Test 1: check random calls to addFirst(), addLast(), and size()
  *    5 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2)
  *   50 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2)
  *  500 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2)
  * 1000 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2)
==> passed

Test 2: check random calls to addFirst(), removeFirst(), and isEmpty()
  *    5 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0)
  *   50 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0)
  *  500 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0)
  * 1000 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addFirst(Deque.java:48)
    TestDeque.random(TestDeque.java:72)
    TestDeque.test2(TestDeque.java:456)
    TestDeque.main(TestDeque.java:830)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.isEmpty()         ==> true
         deque.addFirst(1)
         deque.removeFirst()     ==> 1
         deque.addFirst(3)

  *    5 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addFirst(Deque.java:48)
    TestDeque.random(TestDeque.java:72)
    TestDeque.test2(TestDeque.java:457)
    TestDeque.main(TestDeque.java:830)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addFirst(0)
         deque.removeFirst()     ==> 0
         deque.addFirst(2)

  *   50 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addFirst(Deque.java:48)
    TestDeque.random(TestDeque.java:72)
    TestDeque.test2(TestDeque.java:458)
    TestDeque.main(TestDeque.java:830)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.isEmpty()         ==> true
         deque.addFirst(1)
         deque.removeFirst()     ==> 1
         deque.addFirst(3)

  *  500 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addFirst(Deque.java:48)
    TestDeque.random(TestDeque.java:72)
    TestDeque.test2(TestDeque.java:459)
    TestDeque.main(TestDeque.java:830)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.addFirst(2)
         deque.isEmpty()         ==> false
         deque.removeFirst()     ==> 2
         deque.addFirst(5)

  * 1000 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addFirst(Deque.java:48)
    TestDeque.random(TestDeque.java:72)
    TestDeque.test2(TestDeque.java:460)
    TestDeque.main(TestDeque.java:830)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addFirst(0)
         deque.removeFirst()     ==> 0
         deque.addFirst(2)

==> FAILED

Test 3: check random calls to addFirst(), removeLast(), and isEmpty()
  *    5 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: 2

    Deque.removeLast(Deque.java:119)
    TestDeque.random(TestDeque.java:106)
    TestDeque.test3(TestDeque.java:469)
    TestDeque.main(TestDeque.java:831)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addFirst(0)
         deque.addFirst(1)
         deque.removeLast()

  *   50 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0)
    - failed on operation 9 of 50
    - student   removeLast() returned null
    - reference removeLast() returned 0
    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addFirst(0)
         deque.addFirst(1)
         deque.addFirst(2)
         deque.addFirst(3)
         deque.addFirst(4)
         deque.addFirst(5)
         deque.addFirst(6)
         deque.addFirst(7)
         s     ==> false
         deque.removeLast()      ==> null

  *  500 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addFirst(Deque.java:48)
    TestDeque.random(TestDeque.java:72)
    TestDeque.test3(TestDeque.java:471)
    TestDeque.main(TestDeque.java:831)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addFirst(0)
         deque.removeLast()      ==> 0
         deque.addFirst(2)

  * 1000 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addFirst(Deque.java:48)
    TestDeque.random(TestDeque.java:72)
    TestDeque.test3(TestDeque.java:472)
    TestDeque.main(TestDeque.java:831)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addFirst(0)
         deque.removeLast()      ==> 0
         deque.addFirst(2)

  *    5 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addFirst(Deque.java:48)
    TestDeque.random(TestDeque.java:72)
    TestDeque.test3(TestDeque.java:473)
    TestDeque.main(TestDeque.java:831)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addFirst(0)
         deque.removeLast()      ==> 0
         deque.addFirst(2)

  *   50 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.isEmpty(Deque.java:35)
    TestDeque.random(TestDeque.java:123)
    TestDeque.test3(TestDeque.java:474)
    TestDeque.main(TestDeque.java:831)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.addFirst(2)
         deque.removeLast()      ==> 2
         deque.isEmpty()

  *  500 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addFirst(Deque.java:48)
    TestDeque.random(TestDeque.java:72)
    TestDeque.test3(TestDeque.java:475)
    TestDeque.main(TestDeque.java:831)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.addFirst(3)
         deque.removeLast()      ==> 3
         deque.addFirst(5)

  * 1000 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.isEmpty(Deque.java:35)
    TestDeque.random(TestDeque.java:123)
    TestDeque.test3(TestDeque.java:476)
    TestDeque.main(TestDeque.java:831)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addFirst(0)
         deque.removeLast()      ==> 0
         deque.isEmpty()

==> FAILED

Test 4: check random calls to addLast(), removeLast(), and isEmpty()
  *    5 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0)
  *   50 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0)
  *  500 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0)
  * 1000 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addLast(Deque.java:78)
    TestDeque.random(TestDeque.java:77)
    TestDeque.test4(TestDeque.java:488)
    TestDeque.main(TestDeque.java:832)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addLast(0)
         deque.removeLast()      ==> 0
         deque.addLast(2)

  *    5 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addLast(Deque.java:78)
    TestDeque.random(TestDeque.java:77)
    TestDeque.test4(TestDeque.java:489)
    TestDeque.main(TestDeque.java:832)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addLast(0)
         deque.removeLast()      ==> 0
         deque.addLast(2)

  *   50 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addLast(Deque.java:78)
    TestDeque.random(TestDeque.java:77)
    TestDeque.test4(TestDeque.java:490)
    TestDeque.main(TestDeque.java:832)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addLast(0)
         deque.removeLast()      ==> 0
         deque.addLast(2)

  *  500 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.isEmpty(Deque.java:35)
    TestDeque.random(TestDeque.java:123)
    TestDeque.test4(TestDeque.java:491)
    TestDeque.main(TestDeque.java:832)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addLast(0)
         deque.removeLast()      ==> 0
         deque.isEmpty()

  * 1000 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.isEmpty(Deque.java:35)
    TestDeque.random(TestDeque.java:123)
    TestDeque.test4(TestDeque.java:492)
    TestDeque.main(TestDeque.java:832)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addLast(0)
         deque.removeLast()      ==> 0
         deque.isEmpty()

==> FAILED

Test 5: check random calls to addLast(), removeFirst(), and isEmpty()
  *    5 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0)
  *   50 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0)
  *  500 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0)
  * 1000 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.isEmpty(Deque.java:35)
    TestDeque.random(TestDeque.java:123)
    TestDeque.test5(TestDeque.java:504)
    TestDeque.main(TestDeque.java:833)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.isEmpty()         ==> true
         deque.addLast(1)
         deque.removeFirst()     ==> 1
         deque.isEmpty()

  *    5 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addLast(Deque.java:78)
    TestDeque.random(TestDeque.java:77)
    TestDeque.test5(TestDeque.java:505)
    TestDeque.main(TestDeque.java:833)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addLast(0)
         deque.removeFirst()     ==> 0
         deque.addLast(2)

  *   50 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addLast(Deque.java:78)
    TestDeque.random(TestDeque.java:77)
    TestDeque.test5(TestDeque.java:506)
    TestDeque.main(TestDeque.java:833)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.addLast(2)
         deque.removeFirst()     ==> 2
         deque.addLast(4)

  *  500 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addLast(Deque.java:78)
    TestDeque.random(TestDeque.java:77)
    TestDeque.test5(TestDeque.java:507)
    TestDeque.main(TestDeque.java:833)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.isEmpty()         ==> true
         deque.addLast(1)
         deque.removeFirst()     ==> 1
         deque.addLast(3)

  * 1000 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.isEmpty(Deque.java:35)
    TestDeque.random(TestDeque.java:123)
    TestDeque.test5(TestDeque.java:508)
    TestDeque.main(TestDeque.java:833)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addLast(0)
         deque.isEmpty()         ==> false
         deque.removeFirst()     ==> 0
         deque.isEmpty()

==> FAILED

Test 6: check random calls to addFirst(), addLast(), removeFirst(),
        removeLast(), isEmpty(), and size()
  *    5 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
  *   50 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addFirst(Deque.java:48)
    TestDeque.random(TestDeque.java:72)
    TestDeque.test6(TestDeque.java:520)
    TestDeque.main(TestDeque.java:834)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addFirst(0)
         deque.addLast(1)
         deque.removeFirst()     ==> 0
         deque.removeLast()      ==> 1
         deque.addFirst(4)

  *  500 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
    - failed on operation 4 of 500
    - student   removeLast() returned null
    - reference removeLast() returned 0
    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addFirst(0)
         deque.addFirst(1)
         deque.isEmpty()         ==> false
         deque.addFirst(3)
         deque.removeLast()      ==> null

  * 1000 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1)
    - failed on operation 5 of 1000
    - student   removeLast() returned null
    - reference removeLast() returned 1
    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addFirst(0)
         deque.addLast(1)
         deque.addFirst(2)
         deque.addFirst(3)
         deque.addFirst(4)
         deque.removeLast()      ==> null

  *    5 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.isEmpty(Deque.java:35)
    TestDeque.random(TestDeque.java:123)
    TestDeque.test6(TestDeque.java:523)
    TestDeque.main(TestDeque.java:834)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addLast(0)
         deque.isEmpty()         ==> false
         deque.removeLast()      ==> 0
         deque.size()            ==> 0
         deque.isEmpty()

  *   50 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.isEmpty(Deque.java:35)
    TestDeque.random(TestDeque.java:123)
    TestDeque.test6(TestDeque.java:524)
    TestDeque.main(TestDeque.java:834)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.size()            ==> 0
         deque.addFirst(1)
         deque.isEmpty()         ==> false
         deque.addLast(3)
         deque.removeLast()      ==> 3
         deque.removeLast()      ==> 1
         deque.isEmpty()

  *  500 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.isEmpty(Deque.java:35)
    TestDeque.random(TestDeque.java:123)
    TestDeque.test6(TestDeque.java:525)
    TestDeque.main(TestDeque.java:834)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.size()            ==> 0
         deque.addFirst(1)
         deque.removeLast()      ==> 1
         deque.isEmpty()

  * 1000 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: -1

    Deque.addLast(Deque.java:78)
    TestDeque.random(TestDeque.java:77)
    TestDeque.test6(TestDeque.java:526)
    TestDeque.main(TestDeque.java:834)

    - sequence of operations was:
         Deque<Integer> deque = new Deque<Integer>()
         deque.addLast(0)
         deque.removeFirst()     ==> 0
         deque.addLast(2)

==> FAILED

Test 7: check removeFirst() and removeLast() from an empty deque
  * removeFirst()
  * removeLast()
==> passed

Test 8: check whether two Deque objects can be created at the same time
  isEmpty() returns wrong value
  student   isEmpty() = true
  reference isEmpty() = false

  Failed on 5th removeFirst() operation in deque 1

  isEmpty() returns wrong value
  student   isEmpty() = true
  reference isEmpty() = false

  Failed on 487th removeFirst() operation in deque 1

==> FAILED

Test 9: check iterator() after n calls to addFirst()
  * n = 10
    - number of student   entries = 0
    - number of reference entries = 10

  * n = 50
    - number of student   entries = 0
    - number of reference entries = 50

==> FAILED

Test 10: check iterator() after each of m intermixed calls to
         addFirst(), addLast(), removeFirst(), and removeLast()
  * m = 20
    - number of student   entries = 0
    - number of reference entries = 1
    - iterator failed after applying operation 1
    - sequence of operations was:
         Deque deque<Integer> = new Deque<Integer>()
         deque.addLast(1)

  * m = 50
    - number of student   entries = 0
    - number of reference entries = 1
    - iterator failed after applying operation 1
    - sequence of operations was:
         Deque deque<Integer> = new Deque<Integer>()
         deque.addFirst(1)

  * m = 100
    - number of student   entries = 0
    - number of reference entries = 1
    - iterator failed after applying operation 1
    - sequence of operations was:
         Deque deque<Integer> = new Deque<Integer>()
         deque.addLast(1)

  * m = 1000
    - number of student   entries = 0
    - number of reference entries = 1
    - iterator failed after applying operation 1
    - sequence of operations was:
         Deque deque<Integer> = new Deque<Integer>()
         deque.addLast(1)

==> FAILED

Test 11: create two nested iterators to same deque
  * n = 10
    - outer iterator returned fewer than 10 items

  * n = 50
    - outer iterator returned fewer than 50 items

==> FAILED

Test 12: create two parallel iterators to same deque
    - failed on call 0 to hasNext()
    - student   iterator 1 hasNext() = false
    - student   iterator 2 hasNext() = false
    - reference iterator   hasNext() = true

    - failed on call 0 to hasNext()
    - student   iterator 1 hasNext() = false
    - student   iterator 2 hasNext() = false
    - reference iterator   hasNext() = true

==> FAILED

Test 13: create Deque objects of different parameterized types
==> passed

Test 14: call addFirst() and addLast() with null argument
==> passed

Test 15: check that remove() and next() throw the specified exceptions in iterator()
    - failed trying to call next() twice on an iterator with two items

    java.lang.ArrayIndexOutOfBoundsException: 2

    Deque$ArrayIterator.next(Deque.java:160)
    TestDeque.test15(TestDeque.java:761)
    TestDeque.main(TestDeque.java:843)

==> FAILED

Test 16: call iterator() when the deque is empty
    - hasNext() returns true

==> FAILED


Total: 4/16 tests passed!


================================================================
Testing correctness of RandomizedQueue
*-----------------------------------------------------------
Running 18 total tests.

Tests 1-4 make random calls to enqueue(), dequeue(), sample(),
isEmpty(), and size(). The probabilities of each operation are
(p1, p2, p3, p4, p5), respectively.

Test 1: check random calls to enqueue() and size()
  *    5 random calls (0.8, 0.0, 0.0, 0.0, 0.2)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test1(TestRandomizedQueue.java:734)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1167)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.size()        ==> 0
         rq.enqueue(2)
         rq.enqueue(0)

  *   50 random calls (0.8, 0.0, 0.0, 0.0, 0.2)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test1(TestRandomizedQueue.java:735)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1167)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(2)
         rq.enqueue(25)

  *  500 random calls (0.8, 0.0, 0.0, 0.0, 0.2)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test1(TestRandomizedQueue.java:736)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1167)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(257)
         rq.enqueue(276)

  * 1000 random calls (0.8, 0.0, 0.0, 0.0, 0.2)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test1(TestRandomizedQueue.java:737)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1167)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(294)
         rq.enqueue(178)

==> FAILED

Test 2: check random calls to enqueue() and dequeue()
  *    5 random calls (0.7, 0.1, 0.0, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test2(TestRandomizedQueue.java:744)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1170)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(3)
         rq.size()        ==> 1
         rq.isEmpty()     ==> false
         rq.enqueue(4)

  *   50 random calls (0.7, 0.1, 0.0, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test2(TestRandomizedQueue.java:745)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1170)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(15)
         rq.enqueue(38)

  *  500 random calls (0.7, 0.1, 0.0, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test2(TestRandomizedQueue.java:746)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1170)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(232)
         rq.enqueue(6)

  * 1000 random calls (0.7, 0.1, 0.0, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test2(TestRandomizedQueue.java:747)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1170)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(687)
         rq.enqueue(888)

  *    5 random calls (0.1, 0.7, 0.0, 0.1, 0.1)
    java.lang.IllegalArgumentException: invalid range: [0, 0)

    edu.princeton.cs.algs4.StdRandom.uniform(StdRandom.java:265)
    RandomizedQueue.dequeue(RandomizedQueue.java:64)
    TestRandomizedQueue.random(TestRandomizedQueue.java:115)
    TestRandomizedQueue.test2(TestRandomizedQueue.java:748)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1170)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(2)
         rq.dequeue()

  *   50 random calls (0.1, 0.7, 0.0, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test2(TestRandomizedQueue.java:749)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1170)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(38)
         rq.enqueue(46)

  *  500 random calls (0.1, 0.7, 0.0, 0.1, 0.1)
    java.lang.IllegalArgumentException: invalid range: [0, 0)

    edu.princeton.cs.algs4.StdRandom.uniform(StdRandom.java:265)
    RandomizedQueue.dequeue(RandomizedQueue.java:64)
    TestRandomizedQueue.random(TestRandomizedQueue.java:115)
    TestRandomizedQueue.test2(TestRandomizedQueue.java:750)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1170)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.isEmpty()     ==> true
         rq.isEmpty()     ==> true
         rq.isEmpty()     ==> true
         rq.isEmpty()     ==> true
         rq.size()        ==> 0
         rq.enqueue(410)
         rq.isEmpty()     ==> false
         rq.dequeue()

  * 1000 random calls (0.1, 0.7, 0.0, 0.1, 0.1)
    java.lang.IllegalArgumentException: invalid range: [0, 0)

    edu.princeton.cs.algs4.StdRandom.uniform(StdRandom.java:265)
    RandomizedQueue.dequeue(RandomizedQueue.java:64)
    TestRandomizedQueue.random(TestRandomizedQueue.java:115)
    TestRandomizedQueue.test2(TestRandomizedQueue.java:751)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1170)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.size()        ==> 0
         rq.isEmpty()     ==> true
         rq.isEmpty()     ==> true
         rq.enqueue(120)
         rq.size()        ==> 1
         rq.dequeue()

==> FAILED

Test 3: check random calls to enqueue(), sample(), and size()
  *    5 random calls (0.8, 0.0, 0.1, 0.0, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test3(TestRandomizedQueue.java:758)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1173)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(2)
         rq.enqueue(3)

  *   50 random calls (0.8, 0.0, 0.1, 0.0, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test3(TestRandomizedQueue.java:759)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1173)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(9)
         rq.enqueue(33)

  *  500 random calls (0.8, 0.0, 0.1, 0.0, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test3(TestRandomizedQueue.java:760)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1173)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(203)
         rq.enqueue(72)

  * 1000 random calls (0.8, 0.0, 0.1, 0.0, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test3(TestRandomizedQueue.java:761)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1173)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(613)
         rq.enqueue(513)

  *    5 random calls (0.1, 0.0, 0.8, 0.0, 0.1)
    java.lang.IllegalArgumentException: invalid range: [0, 0)

    edu.princeton.cs.algs4.StdRandom.uniform(StdRandom.java:265)
    RandomizedQueue.sample(RandomizedQueue.java:81)
    TestRandomizedQueue.random(TestRandomizedQueue.java:152)
    TestRandomizedQueue.test3(TestRandomizedQueue.java:762)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1173)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(4)
         rq.sample()

  *   50 random calls (0.1, 0.0, 0.8, 0.0, 0.1)
    java.lang.IllegalArgumentException: invalid range: [0, 0)

    edu.princeton.cs.algs4.StdRandom.uniform(StdRandom.java:265)
    RandomizedQueue.sample(RandomizedQueue.java:81)
    TestRandomizedQueue.random(TestRandomizedQueue.java:152)
    TestRandomizedQueue.test3(TestRandomizedQueue.java:763)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1173)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.size()        ==> 0
         rq.size()        ==> 0
         rq.size()        ==> 0
         rq.size()        ==> 0
         rq.size()        ==> 0
         rq.enqueue(30)
         rq.sample()

  *  500 random calls (0.1, 0.0, 0.8, 0.0, 0.1)
    java.lang.IllegalArgumentException: invalid range: [0, 0)

    edu.princeton.cs.algs4.StdRandom.uniform(StdRandom.java:265)
    RandomizedQueue.sample(RandomizedQueue.java:81)
    TestRandomizedQueue.random(TestRandomizedQueue.java:152)
    TestRandomizedQueue.test3(TestRandomizedQueue.java:764)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1173)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.size()        ==> 0
         rq.size()        ==> 0
         rq.enqueue(497)
         rq.sample()

  * 1000 random calls (0.1, 0.0, 0.8, 0.0, 0.1)
    java.lang.IllegalArgumentException: invalid range: [0, 0)

    edu.princeton.cs.algs4.StdRandom.uniform(StdRandom.java:265)
    RandomizedQueue.sample(RandomizedQueue.java:81)
    TestRandomizedQueue.random(TestRandomizedQueue.java:152)
    TestRandomizedQueue.test3(TestRandomizedQueue.java:765)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1173)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(230)
         rq.sample()

==> FAILED

Test 4: check random calls to enqueue(), dequeue(), sample(), isEmpty(), and size()
  *    5 random calls (0.6, 0.1, 0.1, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test4(TestRandomizedQueue.java:772)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1176)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(3)
         rq.enqueue(3)

  *   50 random calls (0.6, 0.1, 0.1, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test4(TestRandomizedQueue.java:773)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1176)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(5)
         rq.enqueue(23)

  *  500 random calls (0.6, 0.1, 0.1, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test4(TestRandomizedQueue.java:774)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1176)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(17)
         rq.enqueue(467)

  * 1000 random calls (0.6, 0.1, 0.1, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test4(TestRandomizedQueue.java:775)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1176)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(508)
         rq.enqueue(331)

  *    5 random calls (0.1, 0.6, 0.1, 0.1, 0.1)
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.random(TestRandomizedQueue.java:104)
    TestRandomizedQueue.test4(TestRandomizedQueue.java:776)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1176)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.isEmpty()     ==> true
         rq.size()        ==> 0
         rq.enqueue(1)
         rq.enqueue(0)

  *   50 random calls (0.1, 0.6, 0.1, 0.1, 0.1)
    java.lang.IllegalArgumentException: invalid range: [0, 0)

    edu.princeton.cs.algs4.StdRandom.uniform(StdRandom.java:265)
    RandomizedQueue.sample(RandomizedQueue.java:81)
    TestRandomizedQueue.random(TestRandomizedQueue.java:152)
    TestRandomizedQueue.test4(TestRandomizedQueue.java:777)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1176)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.enqueue(32)
         rq.sample()

  *  500 random calls (0.1, 0.6, 0.1, 0.1, 0.1)
    java.lang.IllegalArgumentException: invalid range: [0, 0)

    edu.princeton.cs.algs4.StdRandom.uniform(StdRandom.java:265)
    RandomizedQueue.dequeue(RandomizedQueue.java:64)
    TestRandomizedQueue.random(TestRandomizedQueue.java:115)
    TestRandomizedQueue.test4(TestRandomizedQueue.java:778)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1176)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.isEmpty()     ==> true
         rq.isEmpty()     ==> true
         rq.isEmpty()     ==> true
         rq.enqueue(228)
         rq.dequeue()

  * 1000 random calls (0.1, 0.6, 0.1, 0.1, 0.1)
    java.lang.IllegalArgumentException: invalid range: [0, 0)

    edu.princeton.cs.algs4.StdRandom.uniform(StdRandom.java:265)
    RandomizedQueue.dequeue(RandomizedQueue.java:64)
    TestRandomizedQueue.random(TestRandomizedQueue.java:115)
    TestRandomizedQueue.test4(TestRandomizedQueue.java:779)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1176)

    - sequence of dequeue operations was:
         RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>()
         rq.size()        ==> 0
         rq.size()        ==> 0
         rq.isEmpty()     ==> true
         rq.size()        ==> 0
         rq.isEmpty()     ==> true
         rq.enqueue(755)
         rq.isEmpty()     ==> false
         rq.dequeue()

==> FAILED

Test 5: call dequeue() and sample() from an empty randomized queue
  * dequeue()
  * sample()
     java.util.NoSuchElementException not thrown
==> FAILED

Test 6: create multiple randomized queue objects at the same time
  * n = 10
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkTwoRandomizedQueues(TestRandomizedQueue.java:245)
    TestRandomizedQueue.test6(TestRandomizedQueue.java:821)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1182)

  * n = 100
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkTwoRandomizedQueues(TestRandomizedQueue.java:245)
    TestRandomizedQueue.test6(TestRandomizedQueue.java:822)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1182)

==> FAILED

Test 7: check that iterator() returns correct items after a sequence
        of n enqueue() operations
  * n = 10
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkIteratorAfterEnqueue(TestRandomizedQueue.java:833)
    TestRandomizedQueue.test7(TestRandomizedQueue.java:850)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1185)

  * n = 50
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkIteratorAfterEnqueue(TestRandomizedQueue.java:833)
    TestRandomizedQueue.test7(TestRandomizedQueue.java:851)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1185)

==> FAILED

Test 8: check that iterator() returns correct items after sequence
        of m enqueue() and dequeue() operations
  * m = 10
    java.lang.IllegalArgumentException: invalid range: [0, 0)

    edu.princeton.cs.algs4.StdRandom.uniform(StdRandom.java:265)
    RandomizedQueue.dequeue(RandomizedQueue.java:64)
    TestRandomizedQueue.checkIteratorAfterEnqueueDequeue(TestRandomizedQueue.java:872)
    TestRandomizedQueue.test8(TestRandomizedQueue.java:902)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1188)

  * m = 1000
    java.lang.IllegalArgumentException: invalid range: [0, 0)

    edu.princeton.cs.algs4.StdRandom.uniform(StdRandom.java:265)
    RandomizedQueue.dequeue(RandomizedQueue.java:64)
    TestRandomizedQueue.checkIteratorAfterEnqueueDequeue(TestRandomizedQueue.java:872)
    TestRandomizedQueue.test8(TestRandomizedQueue.java:903)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1188)

==> FAILED

Test 9: create two nested iterators over the same randomized queue
  * n = 10
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkTwoNestedIterators(TestRandomizedQueue.java:311)
    TestRandomizedQueue.test9(TestRandomizedQueue.java:910)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1191)

  * n = 50
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkTwoNestedIterators(TestRandomizedQueue.java:311)
    TestRandomizedQueue.test9(TestRandomizedQueue.java:911)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1191)

==> FAILED

Test 10: create two parallel iterators over the same randomized queue
  * n = 10
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkTwoParallelIterators(TestRandomizedQueue.java:407)
    TestRandomizedQueue.test10(TestRandomizedQueue.java:918)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1194)

  * n = 50
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkTwoParallelIterators(TestRandomizedQueue.java:407)
    TestRandomizedQueue.test10(TestRandomizedQueue.java:919)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1194)

==> FAILED

Test 11: create two iterators over different randomized queues
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.test11(TestRandomizedQueue.java:934)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1197)

==> FAILED

Test 12: create RandomizedQueue objects of different parameterized types
    java.lang.IllegalArgumentException: invalid range: [0, 0)

    edu.princeton.cs.algs4.StdRandom.uniform(StdRandom.java:265)
    RandomizedQueue.dequeue(RandomizedQueue.java:64)
    TestRandomizedQueue.test12(TestRandomizedQueue.java:962)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1200)

==> FAILED

Test 13: check randomness of sample() by enqueueing n items, repeatedly calling
         sample(), and counting the frequency of each item
  * n = 3, trials = 12000
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkRandomnessOfSample(TestRandomizedQueue.java:503)
    TestRandomizedQueue.test13(TestRandomizedQueue.java:980)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1203)

  * n = 5, trials = 12000
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkRandomnessOfSample(TestRandomizedQueue.java:503)
    TestRandomizedQueue.test13(TestRandomizedQueue.java:981)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1203)

  * n = 8, trials = 12000
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkRandomnessOfSample(TestRandomizedQueue.java:503)
    TestRandomizedQueue.test13(TestRandomizedQueue.java:982)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1203)

  * n = 10, trials = 12000
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkRandomnessOfSample(TestRandomizedQueue.java:503)
    TestRandomizedQueue.test13(TestRandomizedQueue.java:983)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1203)

==> FAILED

Test 14: check randomness of dequeue() by enqueueing n items, dequeueing n items,
         and seeing whether each of the n! permutations is equally likely
  * n = 2, trials = 12000
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkRandomnessOfDequeue(TestRandomizedQueue.java:564)
    TestRandomizedQueue.test14(TestRandomizedQueue.java:992)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1206)

  * n = 3, trials = 12000
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkRandomnessOfDequeue(TestRandomizedQueue.java:564)
    TestRandomizedQueue.test14(TestRandomizedQueue.java:993)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1206)

  * n = 4, trials = 12000
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkRandomnessOfDequeue(TestRandomizedQueue.java:564)
    TestRandomizedQueue.test14(TestRandomizedQueue.java:994)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1206)

  * n = 5, trials = 12000
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkRandomnessOfDequeue(TestRandomizedQueue.java:564)
    TestRandomizedQueue.test14(TestRandomizedQueue.java:995)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1206)

==> FAILED

Test 15: check randomness of iterator() by enqueueing n items, iterating over those
         n items, and seeing whether each of the n! permutations is equally likely
  * n = 2, trials = 12000
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkRandomnessOfIterator(TestRandomizedQueue.java:649)
    TestRandomizedQueue.test15(TestRandomizedQueue.java:1004)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1209)

  * n = 3, trials = 12000
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkRandomnessOfIterator(TestRandomizedQueue.java:649)
    TestRandomizedQueue.test15(TestRandomizedQueue.java:1005)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1209)

  * n = 4, trials = 12000
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkRandomnessOfIterator(TestRandomizedQueue.java:649)
    TestRandomizedQueue.test15(TestRandomizedQueue.java:1006)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1209)

  * n = 5, trials = 12000
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.checkRandomnessOfIterator(TestRandomizedQueue.java:649)
    TestRandomizedQueue.test15(TestRandomizedQueue.java:1007)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1209)

==> FAILED

Test 16: call enqueue() with a null argument
    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.test16(TestRandomizedQueue.java:1019)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1212)

    - throws an exception when constructing a RandomizedQueue with two strings

==> FAILED

Test 17: check that remove() and next() throw the specified exceptions in iterator()
    - failed trying to enqueue() two items and calling iterator()

    java.lang.ArrayIndexOutOfBoundsException: 2

    RandomizedQueue.enqueue(RandomizedQueue.java:51)
    TestRandomizedQueue.test17(TestRandomizedQueue.java:1066)
    TestRandomizedQueue.main(TestRandomizedQueue.java:1215)

==> FAILED

Test 18: call iterator() when randomized queue is empty
    - hasNext() returns true

==> FAILED


Total: 0/18 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference RandomizedQueue and Deque)
********************************************************************************

Testing correctness of Permutation
*-----------------------------------------------------------
Tests 1-5 call the main() function directly, resetting standard input
before each call.

Running 9 total tests.

Test 1a: check formatting for sample inputs from assignment specification
  % java Permutation 3 < distinct.txt
  A
  I
  F

  % java Permutation 3 < distinct.txt
  D
  H
  E

  % java Permutation 8 < duplicates.txt
  BB
  BB
  AA
  BB
  CC
  BB
  BB
  CC

==> passed

Test 1b: check formatting for other inputs
  % java Permutation 8 < mediumTale.txt
  age
  wisdom
  the
  was
  was
  of
  best
  it

  % java Permutation 0 < distinct.txt
  [no output]

==> passed

Test 2: check that main() reads all data from standard input
  * filename = distinct.txt, k = 3
  * filename = distinct.txt, k = 3
  * filename = duplicates.txt, k = 8
  * filename = mediumTale.txt, k = 8
==> passed

Test 3a: check that main() prints each item from the sequence at most once
         (for inputs with no duplicate strings)
  * filename = distinct.txt, k = 3
  * filename = distinct.txt, k = 1
  * filename = distinct.txt, k = 9
  * filename = permutation6.txt, k = 6
  * filename = permutation10.txt, k = 10
==> passed

Test 3b: check that main() prints each item from the sequence at most once
         (for inputs with duplicate strings)
  * filename = duplicates.txt, k = 8
  * filename = duplicates.txt, k = 3
  * filename = permutation8.txt, k = 6
  * filename = permutation8.txt, k = 2
  * filename = tinyTale.txt, k = 10
==> passed

Test 3c: check that main() prints each item from the sequence at most once
         (for inputs with newlines)
  * filename = mediumTale.txt, k = 10
  * filename = mediumTale.txt, k = 20
  * filename = tale.txt, k = 10
  * filename = tale.txt, k = 50
==> passed

Test 4: check main() when k = 0
  * filename = distinct.txt, k = 0
  * filename = distinct.txt, k = 0
==> passed

Test 5a: check that permutations are uniformly random
         (for inputs with no duplicate strings)
  * filename = permutation4.txt, k = 1
  * filename = permutation4.txt, k = 2
  * filename = permutation4.txt, k = 3
  * filename = permutation4.txt, k = 4
  * filename = permutation6.txt, k = 2
==> passed

Test 5b: check that permutations are uniformly random
         (for inputs with duplicate strings)
  * filename = permutation5.txt, k = 1
  * filename = permutation5.txt, k = 2
  * filename = permutation5.txt, k = 3
  * filename = duplicates.txt, k = 3
  * filename = permutation8.txt, k = 2
==> passed

Total: 9/9 tests passed!


================================================================
********************************************************************************
*  TIMING (substituting reference RandomizedQueue and Deque)
********************************************************************************

Timing Permutation
*-----------------------------------------------------------
Running 23 total tests.

Test 1: count calls to methods in StdIn
  * java Permutation 5 < distinct.txt
  * java Permutation 10 < permutation10.txt
  * java Permutation 1 < mediumTale.txt
  * java Permutation 20 < tale.txt
  * java Permutation 100 < tale.txt
  * java Permutation 16412 < tale.txt
==> passed

Test 2: count calls to methods in Deque and RandomizedQueue
  * java Permutation 5 < distinct.txt
  * java Permutation 10 < permutation10.txt
  * java Permutation 1 < mediumTale.txt
  * java Permutation 20 < tale.txt
  * java Permutation 100 < tale.txt
  * java Permutation 16412 < tale.txt
==> passed

Test 3: count calls to methods in StdRandom
  * java Permutation 5 < distinct.txt
  * java Permutation 10 < permutation10.txt
  * java Permutation 1 < mediumTale.txt
  * java Permutation 20 < tale.txt
  * java Permutation 100 < tale.txt
  * java Permutation 16412 < tale.txt
==> passed

Test 4: Time main() with k = 5, for inputs containing n random strings

                    n  seconds
------------------------------
=> passed        1000     0.00
=> passed        2000     0.00
=> passed        4000     0.00
=> passed        8000     0.00
=> passed       16000     0.01
=> passed       32000     0.01
=> passed       64000     0.03
=> passed      128000     0.05
=> passed      256000     0.26
=> passed      512000     0.26
==> 10/10 tests passed


Test 5: Time main() with k = 1000, for inputs containing n random strings

                    n  seconds
------------------------------
=> passed        1000     0.00
=> passed        2000     0.00
=> passed        4000     0.00
=> passed        8000     0.00
=> passed       16000     0.01
=> passed       32000     0.01
=> passed       64000     0.02
=> passed      128000     0.05
=> passed      256000     0.10
=> passed      512000     0.20
==> 10/10

...

WARNING: the grading output was truncated due to excessive length.
Typically, this is because you have a method that has an unanticipated side effect
(such as printing to standard output or throwing an exception). A large amount of output
can also arise from failing many tests.