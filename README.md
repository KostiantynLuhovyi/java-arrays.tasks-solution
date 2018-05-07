# java-arrays.tasks-solution
**In this repository are located solutions to tasks written in the Java programming language of using onedimensional and multidimensional arrays.**

The name of the packages in which the classes are located to solve the task is the approximate condition of the task.  

A complete description of the task you can see in the package with the solution of the problem in a file with the same name and file extension .txt  .  

Many of functional solutions are implemented in the java-helper.jar library classes. 
A detailed description of the functional contained in the library "java-helper.jar" and used for solving tasks can be found 
in the repository by the link: https://github.com/LugowoyKonstantin/java-helper.tasks-solution

 --  
If you have any questions about this repository or the solution of the tasks in it, you can contact the following contacts:

**email:** _kostya.lugowoy@gmail.com_  
**skype:** _Lugowoy Konstantin ; kostya_lugowoy@outlook.com_  
**linkedin:** _[Konstantin Lugowoy](https://www.linkedin.com/in/lugowoy-konstantin/)_  
**facebook:** _[Konstantin Lugowoy](https://www.facebook.com/lugowoy.konstantin)_  

.  

---
**The package name and description of the solved task that are contained in the root package com.lugowoy.tasks :**  

* multidimensional  
    * constructPascalTriangle  
        * _Write a program that builds a Pascal triangle to a depth of 12.
           Each number of a triangle is stored in an array of the appropriate length, and the array of rows is stored in an array,
           the elements of which are 12 arrays of type int._
    * firstTaskForFormationOfSquareMatrixAccordingToGivenPattern  
        * _Description of the template for the formation of the matrix you will find in the file that is in the package with solution of the task._  
    * secondTaskForFormationOfSquareMatrixAccordingToGivenPattern  
        * _Description of the template for the formation of the matrix you will find in the file that is in the package with solution of the task._  
    * thirdTaskForFormationOfSquareMatrixAccordingToGivenPattern
        * _Description of the template for the formation of the matrix you will find in the file that is in the package with solution of the task._
* onedimensional  
    * calculateSumOfArrayElementsLocatedBetweenMinAndMaxElementsInclusive  
        * _Given an array of numbers.
           Calculate the sum of array elements located between the minimum and maximum elements inclusive._
    * calculateSumOfMaxAndMinElementOfThisParticularSequence  
        * _Given dimensional array A[n].
           Find: max(a2, a4, ..., a2k) + min(a1, a3, ..., a2k-1)._  
    * changeSequenceByMultiplyingElementsBySquareOfMinAndMaxNumbersByRule  
        * _Given integers a1, a2, ..., an.
           It is required to multiply all the terms of the sequence a1, a2, ... 
            by the square of its smallest term, if ak ≥ 0, and the square of its largest term, if ak ≤ 0._  
    * compareMultiplicationModulesOfPositiveAndNegativeNumbers  
        * _In the sequence of integers a1, a2, ..., an, there are positive and negative elements.
           Calculate the multiplication of negative elements P1 and the multiplication of positive elements P2.
           Compare the module P2 with the module P1 and indicate which of the products is larger modulo._  
    * compressArrayByThrowingEverySecondElement  
        * _Given an array with the number of n elements.
           "Squeeze" the array, throwing out every second element from it._  
    * compressArrayByThrowingOutZeroValueElements  
        * _An array containing integers is specified.
           Compress it, throwing out the zero elements._
    * convertSecondSequenceAccordingToRuleDefinedByFirstSequence  
        * _Given integers a1, a2, ..., an and b1, b2, ..., bn.
           Convert the sequence bl, b2, ..., bn by the rule: if ai ≤ 0, then bi is increased by a factor of 10,
           otherwise bi is replaced by zero._  
    * countApplicantsWithAssessmentIsNotAllowedForSecondExam  
        * _On admission to university entrants who have received "two" in the first exam, the second is not allowed.
           The array A[n] written assessment exams obtained in the first test.
           Calculate how much a person is not admitted to the second exam._  
    * countingNumberOfPeopleWhoseAgeIsInGivenInterval  
        * _Write a program whose input is the age of n people.
           The program counting the number of people whose age is in the specified interval._  
    * countOfPositiveAndNegativeAndZeroElementsInArray  
        * _Given an array of integer numbers, whose dimension is N. Calculate how much it negative, positive and zero elements._  
    * createArrayOfEvenNumbersBasedOnAnotherArray 
        * _Given a array of positive numbers a1, a2, ..., an. Create an array of even numbers of this array._  
    * createArrayOfZeroElementsOfAnotherArray  
        * _There are zero elements in an integer array. Create an array of the index of these elements._  
    * createNewArrayFromUniqueElementsOfOriginalArray  
        * _Given a one-dimensional array of numbers, among the elements of which are the same.
           Create a new array from the various elements of the original array._  
    * createNewArrayWhoseElementsWillBeElementsOfSourceEndingInSpecificNumber  
        * _An array of n natural numbers is given.
           Create a new array, the elements of which will be elements of the source, ending in a specific number._  
    * createOrderedArrayFromElementsOfTwoOtherOrderedArrays  
        * _Given two ordered arrays A and B.
           Form from the elements of these arrays an ordered array C._  
    * cyclicallyShiftElementsOfArrayElementsToRightOrLeft  
        * _Given an array A. Cyclically shift the elements of the array to K elements to the right (to the left)._  
    * determineElementsThatAreEqualToHalfSumOfNeighboringElements  
        * _Determine the elements that are equal to the half-sum of the neighboring elements._  
    * determineIndexOfPrimeNumbersInArray  
        * _The integer array of dimension of N is set.
           Whether there are among array elements prime numbers?
           If yes, that to output index numbers of these elements._  
    * determineMaxRadiusOfCircleWithCenterAtOriginWhichContainsAllPoints  
        * _In a one-dimensional array with an even number of elements (2N) there are coordinates of N points of the plane.
           They are arranged in the following order: x1, y1, x2, y2, x3, y3, etc.
           Determine the maximal radius of the circle with the center at the origin, which contains all the points._  
    * determineMostRepeatedElementInArray  
        * _In the array of integers with the number of elements n, find the most repeated number.
           If there are several such numbers, then determine the smallest of them._  
    * determineNumberOfArrayInWhichRemainderOfDivisionIsEqualToCertainNumber  
        * _Determine the number of the array in which the number is equal to dividing a certain number._  
    * determineNumberOfDifferentElementsInOneDimensionalArray  
        * _Given a one-dimensional array of numbers. Find the number of different numbers in this array._  
    * determineNumberOfElementsThatAreIdenticalInTwoSequences  
        * _Two sequences of integers a1, a2, ..., an and b1, b2, ..., bm are given. All the members of the sequences are distinct numbers.
           Find how many elements of the first sequence coincide with the elements of the second sequence._  
    * determineNumberOfLocalMaximaInArray  
        * _Write a program that enter a non-empty array of integers and prints the number of local maxima 
           (an element is a local maximum if it has neighbors elements larger than itself)._  
    * determineNumberOfPairsOfPointsDistanceBetweenWhichIsMaximally  
        * _The coordinates of n points on the plane are given: (X1, Y2), ..., (Xn, Yn) (n ≤ 40).
           Find the number of pairs of points, the distance between which is maximally (assume that such a pair is unique)._  
    * determinePairsOfNumbersFromSequenceWhoseSumIsEqualToEnteredNumber  
        * _Given a sequence of integers a1, a2, ..., an. Indicate pairs of numbers ai, aj such that ai + aj = m._  
    * determineRingWithCenterAtOriginWhichContainsAllPoints  
        * _In a one-dimensional array with an even number of elements (2N) there are coordinates of N points of the plane.
           They are arranged in the following order: x1, y1, x2, y2, x3, y3, etc.
           Define a ring with center at the origin, which contains all points._  
    * determineSequenceOfNumbersIsIncreasing  
        * _Given a sequence of integer numbers a1, a2, ..., an. Determine whether it is increasing._  
    * determineTimeOfStayOfCustomerInQueue  
        * _At the counter of the store, a line of n customers lined up.
           The service time of the i-th customer is tj (i = 1, ..., n).
           Determine the time Ci of the stay of the i-th customer in the queue._  
    * determineTriangleForWhichDifferenceInNumberOfPointsOutsideAndInsideIsMinimal  
        * _In a one-dimensional array with an even number of elements (2N) there are coordinates of N points of the plane.
           They are arranged in the following order: x1, y1, x2, y2, x3, y3, etc.
           Identify three points that are the vertices of a triangle for which the difference in the number of points outside it and inside is minimal._  
    * determineWhetherElementsOfSecondSequenceInFirstSequence  
        * _Two sequences a1, a2, ..., an and b1, b2, ..., bm (m <n) are given.
           In each of them, the members are different.
           Is it true that all members of the second sequence are in the first sequence?_  
    * determineWhetherItIsPossibleToSelectContiguousElementsInOneOfArraysByCondition  
        * _Two integer arrays are given.
           Determine whether in the first of them one can choose k consecutive elements Xj, Xj + 1, ..., Xk-1, 
            so that Xj = Y1, Xj + 1 = Y2, ..., Xk-1 = Yk._  
    * divideOriginalArrayInToEvenAndOddArray  
        * _Given an array with the number of elements of N.
           Form two arrays: the first include elements of the original array with even numbers,
           and in the second - with odd numbers._  
    * findIndicesOfMostRemoteAndLeastDistantPoints  
        * _In a one-dimensional array with an even number of elements (2N) there are coordinates of N points of the plane.
           They are arranged in the following order: x1, y1, x2, y2, x3, y3, etc.
           Find the numbers of the most distant points and the points that are the least distant from each other._  
    * findLengthOfLongestSawtoothSequenceOfSuccessiveNumbers  
        * _Find the length of the longest "sawtooth" sequence of successive numbers Xk <Xk + 1> Xk + 2> ...> Xk + m <Xk + m + 1 <... <Xn._  
    * findLengthOfLongestSequenceOfElementsEqualToZero  
        * _Given an array A. Find the length of the longest sequence of consecutive array elements equal to zero._  
    * findNumbersInSequenceThatAreSquareOfNumber  
        * _Given positive integers a1, a2, a3, ..., an.
           Find among them those whose square is equal to a certain number n._  
    * findSegmentOfArrayIsPolindrome  
        * _Given an array A. Find the segment of the maximum length array in which the first number equals the last, the second the penultimate, and so on.
           Output this segment and its length._  
    * findSubsetOfContiguousElementsOfArraySumOfValuesOfElementsWhichIsEqualToNumber  
        * _Find subset of contiguous elements of array sum of values of elements which is equal to number._  
    * findSumOfArrayOfMultipleElementsToThisPresent  
        * _Given an array of numbers. Find the sum of the elements that are multiples of to this K._  
    * findTwoNumbersWhoseArithmeticMeanIsClosestToNumberEntered  
        * _Given a real number x and an array A [n].
           In the array, find two members whose arithmetic mean is closest to x._  
    * getIntegersInAscendingOrderThatDoesNotBelongToThisArray  
        * _Given an array of integers.
           Find in this array element N minimum and maximum element M. Get in ascending order of all the integers from the interval (N; M),
           which are not included in this array._  
    * insertAnIntegerInSequencePositionWithoutViolatingIncrease  
        * _Given a sequence of integers a1 ≤ a2 ≤ ... ≤ an.
           Insert an integer b into it so that the sequence remains non-decreasing._  
    * interchangedMaximumAndMinimumElementOfArray  
        * _Given integer numbers a1, a2, ..., an. Interchange the maximum and minimum elements._  
    * interchangeElementsStandingOnOddAndEvenPositionsInArray  
        * _The specified one-dimensional array interchange the adjacent elements standing on even places,
           with standing on the odd elements._  
    * locateSnailOnTreeAfterThirtyDays  
        * _Every sunny day, a snail sitting on a tree climbs up 2 cm, and each cloudy day drops down by 1 cm.
           At the beginning of observation, the snail is A cm from the ground on a B-meter tree.
           There is a 30-element array containing information about whether the corresponding observation day was cloudy or sunny.
           Write a program that determines the location of the cochlea at the end of the 30th day of observation._  
    * numberOfPreviouslyFoundPositiveOrNegative  
        * _The sequence of numbers a1, a2, ..., an. To find out what number is found before - positive or negative._  
    * openLockOnDoorByLookingThroughPlayingDice  
        * _The secret lock for the safe consists of 10 cells arranged in a row, into which it is necessary to insert the playing dice.
           But the door is opened only if in any three neighboring cells the sum of the points on the front faces of the cubes is 10.
           (The dice has 1 to 6 dots on each face.)
           Write a program that unravels the lock code, provided that two dice already inserted in the cells._  
    * outputElementsIncludedInInterval  
        * _Given a sequence of integer numbers a1, a2, ..., an. Output elements of it that belong to the interval [c, d]._  
    * outputElementsOfIndexesWhichAreDegreeOfTwo  
        * _Given an array with the number of n elements.
           Print those elements whose indices are degree of two (1, 2, 4, 8, 16, ...)._  
    * outputElementsOneDimensionalArrayAsArgumentsAndAssociatedValues  
        * _In the one-dimensional array are placed: in the first elements of the value of the argument,
           in the following - the corresponding values of the function.
           Print the elements of array n parallel columns (argument and function value)._  
    * outputNumbersForWhichSumOfFirstTwoDigitsIsEqualToSumOfLastTwo  
        * _An array of n four-digit natural numbers is given.
           Output to display only numbers those on which the sum of the first two digits is equal to the sum of the last two digits._  
        * outputNumbersFromArrayThatSatisfyConditionForSolutionOfTask  
        * _Write a program that has an array of random integers and prints three of its (not necessarily distinct) elements x, y, and z, such that x * y = z._  
    * outputNumbersUpToAndIncludingZero  
        * _Given a sequence of numbers. Print out all the numbers up to and including zero._  
    * outputToDisplayNumberForParticularCondition  
        * _Given numbers a1 a2, .... an. Print out only the number, for which the condition ai ≤ i._  
    * replaceSmallestNumberInSequenceByArithmeticMeanOfNumbers  
        * _Given integers a1, a2, ..., an.
           The smallest member of this sequence is replaced by the integer part of the arithmetic mean of all terms, leaving the remaining terms unchanged.
           If there are several smaller terms in the sequence, then replace the last one in order._  
    * replaceTheArrayNumbersOfLargerZ  
        * _Given a sequence of integer numbers a1, a2, ..., an.
           Replace all of its members, of the Z larger, this number. Count the number of substitutions._  
    * replaceWithZerosElementsThatAreModuloGreaterThanTheMaximumElement  
        * _Given integers a1, a2, ..., an. Among them there are positive and negative.
           Replace the zeros with those numbers that they are more modular than a certain number (| ai |> max {a1, a2, ..., an})._  
    * sortArrayConsistingOfZerosOnesAndTwos  
        * _In the array, each element is 0, 1, 2.
           Rearrange the elements of the array so that all zeros are first, then all the ones, and finally all the deuces._  
    * sortArrayInAscendingOrderWithoutChangingTheirRelativePosition  
        * _In a one-dimensional array, rearrange the elements so that negative elements are first located, then zero, and then positive.
           The relative arrangement of the elements does not change._  
    * specifySetOfTrianglesWithVerticesAtGivenPointsThatIntersectWithCircle  
        * _On the n-plane the points are given by their coordinates and a circle of radius R with center at the origin is also given.
          Specify the set of all triangles with vertices at given points intersecting a circle;
          The set of all triangles contained inside the circle._  
