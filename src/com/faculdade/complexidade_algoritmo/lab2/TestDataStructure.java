package com.faculdade.complexidade_algoritmo.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDataStructure
{
	private static String[] languages =
		{ "C", "Mel", "Ruby", "JavaScript", "Java", "C++", "C#", "Assembly", "Pascal", "Cobol", "Python" };
	private static Map<Integer, String> stringsMap = new HashMap<>();
	private static List<String> stringsList = new ArrayList<>();

	private static int instructionsMap;
	private static int instructionsList;

	public static void main(String[] args)
	{
		fillMapAndList();

		searchInAList("Python");
		searchInAMap("Python");

		System.out.println("Using a List: " + instructionsList + " Instructions");
		System.out.println("Using a map: " + instructionsMap + " instructions");
	}

	private static int searchInAList(String string)
	{
		for (int i = 0; i < stringsList.size(); i++)
		{
			instructionsList += 3;
			if (stringsList.get(i).equals(string))
			{
				return i;
			}
		}
		return -1;
	}

	private static int searchInAMap(String string)
	{
		if (stringsMap.get(string.hashCode()) != null)
		{
			instructionsMap += 2;
			return string.hashCode();
		}
		else
		{
			instructionsMap += 2;
			return -1;
		}
	}

	private static void fillMapAndList()
	{
		stringsList = Arrays.asList(languages);

		for (String language : languages)
		{
			stringsMap.put(language.hashCode(), language);
		}
	}
}
