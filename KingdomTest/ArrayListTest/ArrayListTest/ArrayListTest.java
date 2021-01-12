package ArrayListTest;

import Kingdom.Collection.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest
{
  private ArrayList<String> arrayList;

  @BeforeEach
  public void createArray(){
   arrayList = new ArrayList();
  }

  /*
  The test is meant for checking if the specified element has been
  inserted at the specified index within the capacity of the list
  The test will use the boundary value analysis approach,
  it will insert elements at the 0 (element), 50 (element2), and 99 (element3) index.
  */
  @Test
  public void addTheElementAtTheSpecificIndex(){
    //arrange
    int index = 0;
    int index1 = 50;
    int index2 = 99;
    String element = "TEST";
    String element2 = "TEST2";
    String element3 = "TEST3";
    //act
    arrayList.add(index, element);
    arrayList.add(index1, element2);
    arrayList.add(index2, element3);
    //assert
    assertEquals(element, arrayList.get(index));
    assertEquals(element2, arrayList.get(index1));
    assertEquals(element3, arrayList.get(index2));
  }

  /*
  The test is meant to check if the method will throw an
  IndexOutOfBoundsException when inserting the elements on the indexes
  which are outside of the array range.
  The test will insert the element1 at the -1 index, and element2
  at the 100 index.
   */
  @Test
  public void addTheElementAtTheSpecificIndexIndexOutOfBoundsException(){
    //arrange
    int index = -1;
    int index1 = 100;
    String element1 = "TEST";
    String element2 = "TEST2";
    //act and assert
    assertThrows(IndexOutOfBoundsException.class,()-> arrayList.add(index, element1));
    assertThrows(IndexOutOfBoundsException.class, ()->arrayList.add(index1, element2));
  }

  /*
  The test is meant to check if the specified element (element1) will be
  inserted at the rear end of the list.
   */

  @Test
  public void addElementAtTheRearEndOfTheList(){
    //arrange
    String element1 = "TEST";
    //act
    arrayList.add(element1);
    //assert
    assertEquals(element1, arrayList.get(99));
  }

  /*
  The test is used for setting the element at the specified index
  within the ArrayList range.
  The test will use the boundary value analysis approach,
  it will insert elements at the first index of the array (0), somewhere in the
  middle 50 and at the end
  99.
   */

  @Test
  public void setTheElementAtTheSpecifiedIndex(){
    //arrange
    int index = 0;
    int index1 = 50;
    int index2 = 99;
    String element = "TEST";
    String element2 = "TEST2";
    String element3 = "TEST3";
    //act
    arrayList.add(index, element);
    arrayList.add(index1, element2);
    arrayList.add(index2, element3);
    //assert
    assertEquals(element, arrayList.get(index));
    assertEquals(element2, arrayList.get(index1));
    assertEquals(element3, arrayList.get(index2));
  }

  /*
  The test is specified to check if the method will throw the
  IndexOutOfBoundException while inserting the index out of bound.
  The test will check if 2 possibilities, -1 and 100.
   */

  @Test
  public void setElementIndexOutOfBound(){
    //arrange
    int index = -1;
    int index1 = 100;
    String element = "TEST";
    String element2 = "TEST2";
    //assert
    assertThrows(IndexOutOfBoundsException.class, ()-> arrayList.set(index, element));
    assertThrows(IndexOutOfBoundsException.class, ()-> arrayList.set(index1, element2));
  }

  /*
  The test is supposed to check if the method will
  return the correct reference to the object at the specified index.
   */

  @Test
  public void getElementAtTheSpecifiedIndex(){
    //arrange
    int index = 0;
    String element = "TEST";
    //act
    arrayList.add(index, element);
    //assert
    assertEquals(element, arrayList.get(index));
  }

  /*
  The test check for IndexOutOfBoundException
  after trying to get the element by index out of bound of
  the array (-1, and 100)
   */

  @Test
  public void getElementIndexOutOfBound(){
    //arrange
    int index = -1;
    int index2 = 100;
    //assert
    assertThrows(IndexOutOfBoundsException.class, ()-> arrayList.get(index));
    assertThrows(IndexOutOfBoundsException.class, ()-> arrayList.get(index2));
  }

  /*
  Following test checks whether the method removes the object from
  the arrayList by inserting the index of the element within the bound.
   */

  @Test
  public void removeElementAtTheSpecifiedIndex(){
    //arrange
    int index = 0;
    String element = "TEST";
    arrayList.add(index, element);
    //act
    arrayList.remove(index);
    //assert
    assertEquals(null, arrayList.get(index));
  }

  /*
  The test is meant for checking whether
  the method will return the removed object from the list at the
  specified index.
   */

  @Test
  public void removeElementbyIndexAndReturn(){
    //arrange
    int index = 0;
    String element = "TEST";
    arrayList.add(index, element);
    //assert
    assertEquals(element, arrayList.remove(index));
  }

  /*
  Following method will check if the user will try to delete the
  object from the list by using the index of bound, the method will throw
  the IndexOutOfBoundException.
  The indexes to check -1 and 100.
   */

  @Test
  public void removeObjectByIndexIndexOutOfBoundException(){
    //arrange
    int index = -1;
    int index2 = 100;
    //assert
    assertThrows(IndexOutOfBoundsException.class, ()-> arrayList.remove(index));
    assertThrows(IndexOutOfBoundsException.class, ()-> arrayList.remove(index2));
  }

  /*
  The purpose of the test is to determine if the
  object can be removed from the list by the object reference.
   */

  @Test
  public void removeElementByObjectReference(){
    //arrange
    String element = "TEST";
    arrayList.add(0,element);
    //act
    arrayList.remove(element);
    //assert
    assertEquals(null, arrayList.get(0));
  }

  /*
  The test checks whether the method returns the object
  that is being removed from the list by the object reference.
   */
  @Test
  public void removeElementbyReferenceAndReturn(){
    //arrange
    String element = "TEST";
    arrayList.add(element);
    //assert
    assertEquals(element, arrayList.remove(element));
  }

  /*
  The test is checking if the method will throw
  the IllegalStateException when the user is trying to
  remove the object that is not in the list.
   */

  @Test
  public void removerElementByReferenceIllegalStateException(){
    //arrange
    String element = "TEST";
    String element2 = "TEST2";
    arrayList.add(element);
    //assert
    assertThrows(IllegalStateException.class, ()-> arrayList.remove(element2));
  }

  /*
  The test check if the method return the correct
  index of the specified element from the list.
   */

  @Test
  public void indexOf(){
    //arrange
    String element = "TEST";
    //act
    arrayList.add(0, element);
    //assert
    assertEquals(0, arrayList.indexOf(element));

  }

  /*
  The test checks if the list contains the specified
  object, returns true if it does.
   */

  @Test
  public void containsTrue(){
    //arrange
    String element = "TEST";
    //act
    arrayList.add(0, element);
    //assert
    assertTrue(arrayList.contains(element));
  }

  /*
  The test if the method will return false
  when looking for the object that is not in the list.
   */

  @Test
  public void containsFalse(){
    //arrange
    String element = "TEST";
    String element2 = "TEST2";
    //act
    arrayList.add(0, element);
    //assert
    assertFalse(arrayList.contains(element2));
  }

  /*
  The method should return true when the list is filled with
  object and the bound is reached
  */

  @Test
  public void isFullTrue(){
    //arrange, filling the array
    for (int i = 0; i < arrayList.size() ; i++)
    {
      String element = "test" + i;
      arrayList.add(i, element);
    }
    //assert
    assertTrue(arrayList.isFull());
  }

  /*
  The method should return false when the list still has the places
  for new objects to be added.
  */
  @Test
  public void isFullFalse(){
    //assert
    assertFalse(arrayList.isFull());
  }

   /*
  The method should return true when the list does not contain any objects,
  is empty.
  */

  @Test
  public void isEmptyTrue(){
    assertTrue(arrayList.isEmpty());
  }

  /*
  The method should return false when the list does
  contain does contain at least one object.
  */

  @Test
  public void isEmptyFalse(){
    //arrange
    String element = "TEST";
    //act
    arrayList.add(0, element);
    //assert
    assertFalse(arrayList.isEmpty());
  }


  /*
  The test checks whether the method will return the correct size
  of the list.
   */

  @Test
  public void sizeCorrect(){
    //arrange
    String element = "TEST";
    //act
    arrayList.add(element);
    //assert
    assertEquals(1, arrayList.size());
  }

  /*
  The test will check whether the toString method will
  return the correct value, such as:
  (3 string elements): "{A, B, C}"
   */

  @Test
  public void returnToStringLetters(){
    //arrange
    String element = "A";
    String element2 = "B";
    String element3 = "C";

    //act
    arrayList.add(element);
    arrayList.add(element2);
    arrayList.add(element3);

    //assert
    assertEquals("{A, B, C}", arrayList.toString());
  }

  /*
  The test will check whether the toString method will
  return the correct value, such as:
  (3 string elements): "{1, 2, 3}"
   */


//  @Test
//  public void returnToStringNumbers(){
//    //arrange
//    int element = 1;
//    int element2 = 2;
//    int element3 = 3;
//
//    //act
//    arrayList.add(element);
//    arrayList.add(element2);
//    arrayList.add(element3);
//
//    //assert
//    assertEquals("{1, 2, 3}", arrayList.toString());
//  }

  /*
  The test will check whether the toString method will
  return the correct value, when the array is empty such as:
  (3 string elements): "{}"
   */

  @Test
  public void returnToStringEmpty(){
    assertEquals("{}", arrayList.toString());
  }

}