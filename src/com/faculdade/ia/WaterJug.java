package com.faculdade.ia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaterJug
{

	static int target[] = new int[100];
	static int targetN = 0;
	static int A;
	static int B;
	static int Z;
	static int pos = 1;

	public static void main(String[] args) throws IOException
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter maximum capacity of Jug A : ");
		A = Integer.parseInt(br.readLine());
		System.out.print("Enter maximum capacity of Jug B : ");
		B = Integer.parseInt(br.readLine());

		add(A);
		add(B);

		if (B > A)
		{
			int t = A;
			A = B;
			B = t;
			pos = -1;
		}

		int b = B;
		int temp;
		while (b < A)
		{
			temp = A - b;
			add(temp);
			b = b + B;
		}

		temp = b % A;
		temp = add(temp);
		while (temp != 0)
		{
			b = b + B;
			temp = b % A;
			temp = add(temp);
		}

		combination();

		System.out.print("\nYou can measure : ");

		sort();
		show();

		System.out.print("\nEnter amount to be measure : ");
		Z = Integer.parseInt(br.readLine());

		temp = add(Z);
		if (temp != 0)
		{
			System.out.println("\nThis quantity cannot be measured");
			return;
		}
		else if (Z == (A + B))
		{
			System.out.println("\nMinimum solution with 2 steps is\n");
			if (pos == 1)
			{
				System.out.println("        Jug A (" + A + ")   Jug B (" + B + ")");
			}
			else
			{
				System.out.println("        Jug B (" + A + ")   Jug A (" + B + ")");
			}
			System.out.println("Step 0 :    " + 0 + "           " + 0);
			System.out.println("Step 1 :    " + A + "           " + 0);
			System.out.println("Step 2 :    " + A + "           " + B);
			return;
		}

		int countA = solution(1, false);
		int countB = solution(-1, false);

		if (countA < countB)
		{
			System.out.println("\nMinimum solution with " + countA + " steps is\n");
			solution(1, true);
		}
		else
		{
			System.out.println("\nMinimum solution with " + countB + " steps \n");
			solution(-1, true);
		}
	}

	public static int add(int num)
	{
		if ((num > A + B) || (num <= 0))
		{
			return -1;
		}
		for (int i = 0; i < targetN; i++)
		{
			if (target[i] == num)
			{
				return 0;
			}
		}
		target[targetN++] = num;
		return num;
	}

	public static void combination()
	{
		int n = targetN;
		for (int i = 0; i < n - 1; i++)
		{
			for (int j = i + 1; j < n; j++)
			{
				add(target[i] + target[j]);
			}
		}
	}

	public static void show()
	{
		for (int i = 0; i < targetN; i++)
		{
			System.out.print(target[i] + " ");
		}
		System.out.println();
	}

	public static void sort()
	{
		int key, k;

		for (int i = 1; i < targetN; i++) // Insertion Sort
		{
			key = target[i];
			k = i - 1;
			while ((k >= 0) && (target[k] > key))
			{
				target[k + 1] = target[k];
				k = k - 1;
			}
			target[k + 1] = key;
		}
	}

	public static int solution(int dir, boolean showit)
	{
		if (showit == true)
		{
			if (pos == 1)
			{
				System.out.println("        Jug A (" + A + ")   Jug B (" + B + ")");
			}
			else
			{
				System.out.println("        Jug B (" + A + ")   Jug A (" + B + ")");
			}
		}
		int X = A;
		int Y = B;
		if (dir == -1)
		{
			X = B;
			Y = A;
		}

		int x = 0;
		int y = 0;
		int count = 0;
		if (showit == true)
		{
			if (dir == 1)
			{
				System.out.println("Step " + count + " :    " + x + "           " + y);
			}
			else
			{
				System.out.println("Step " + count + " :    " + y + "           " + x);
			}
		}
		do
		{
			count++;
			if (y == Y)
			{
				y = 0; // empty y
			}
			else if (x == 0)
			{
				x = X; // fill x
			}
			else
			{ // fill y from x
				if (x > (Y - y))
				{
					x = x + y - Y;
					y = Y;
				}
				else
				{
					y = y + x;
					x = 0;
				}
			}
			if (showit == true)
			{
				if (dir == 1)
				{
					System.out.println("Step " + count + " :    " + x + "           " + y);
				}
				else
				{
					System.out.println("Step " + count + " :    " + y + "           " + x);
				}
			}
		}
		while (x != Z && y != Z && (x + y) != Z);
		return count;
	}
}
