package org.pg4200.losninger.ex1;

import org.pg4200.datastructure.delete.ArrayDeleteContainer;

public class MyArrayList<T> extends ArrayDeleteContainer<T>
{
	public MyArrayList(int cap)
	{
		super(cap);
	}

	@Override
	public void add(T value) {

		if(size >= data.length)
		{
			Object[] buff = new Object[data.length*2];
			for(int i = 0; i < data.length; i++)
			{
				buff[i] = data[i];
			}
			data = buff;
		}

		data[size] = value;
		size++;
	}
}
