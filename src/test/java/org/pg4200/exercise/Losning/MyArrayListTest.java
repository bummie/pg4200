package org.pg4200.exercise.Losning;

import org.pg4200.datastructure.delete.DeleteContainer;
import org.pg4200.datastructure.delete.DeleteContainerTestTemplate;
import org.pg4200.losninger.ex1.MyArrayList;

public class MyArrayListTest extends DeleteContainerTestTemplate
{
	@Override
	protected <T> DeleteContainer<T> getNewInstance(Class<T> klass)
	{
		return new MyArrayList(1);
	}
}
