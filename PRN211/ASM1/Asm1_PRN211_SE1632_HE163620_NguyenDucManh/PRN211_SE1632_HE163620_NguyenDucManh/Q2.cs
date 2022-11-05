using System;

namespace PRN211_SE1632_HE163620_NguyenDucManh
{
    public class Q2
    {
        static bool IsPrime(int n)
        {
            if (n < 2)
            {
                return false;
            }
            for (int i = 2; i < n; ++i)
            {
                if (n % i == 0)
                {
                    return false;
                }
            }
            return true;
        }

        static bool IsSqr(int n)
        {
            int i = (int)(Math.Sqrt(n));
            return i * i == n;
        }

        static void PrintArray(string s, int[] a)
        {
            Console.Write(s);
            foreach (int i in a)
            {
                Console.Write(i + " ");
            }
            Console.WriteLine();
            Console.WriteLine();

        }

        public static void Run()
        {
            int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            int n = a.Length;
            PrintArray("Array: ", a);

            Console.Write("Prime numbers in array: ");
            int cnt = 0;
            foreach (int i in a)
            {
                if (IsPrime(i))
                {
                    Console.Write(i + " ");
                    ++cnt;
                }
            }
            Console.WriteLine();
            Console.WriteLine();

            Console.WriteLine("There are " + cnt + " primes number and " + (n - cnt) + " composite numbers in array");
            Console.WriteLine();

            for (int i = 1; i < n; ++i)
            {
                for (int j = 0; j < i; ++j)
                {
                    if (a[i] > a[j] && IsSqr(a[i]) && IsSqr(a[j]))
                    {
                        (a[i], a[j]) = (a[j], a[i]);
                    }
                }
            }
            PrintArray("Array after sort square numbers in descending order: ", a);
        }
    }
}
