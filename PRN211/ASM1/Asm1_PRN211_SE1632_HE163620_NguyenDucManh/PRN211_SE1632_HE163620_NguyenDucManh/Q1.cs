using System;

namespace PRN211_SE1632_HE163620_NguyenDucManh
{
    public class Q1
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

        public static void Run()
        {
            int n;
            while (true)
            {
                try
                {
                    Console.Write("Input a positive integer: ");
                    n = Convert.ToInt32(Console.ReadLine());
                    if (n < 1)
                    {
                        throw new Exception();
                    }
                    break;
                }
                catch
                {
                    Console.WriteLine("Invalid positive integer!");
                }
            }
            Console.WriteLine();

            Console.Write("Odd composite numbers < n: ");
            for (int i = 1; i < n; i+=2)
            {
                if (!IsPrime(i))
                {
                    Console.Write(i + " ");
                }
            }
            Console.WriteLine();
            Console.WriteLine();

            Console.Write(n + " second prime numbers: ");
            int cnt = 0;
            for (int i = 2; cnt < 2 * n; ++i)
            {
                if (IsPrime(i))
                {
                    ++cnt;
                    if (cnt > n)
                    {
                        Console.Write(i + " ");
                    }
                }
            }
            Console.WriteLine();
            Console.WriteLine();

            Console.WriteLine("In the natural numbers <= n, there are: ");
            Console.WriteLine("\t" + (n / 3 + 1) + " numbers divisible by 3");
            Console.WriteLine("\t" + ((n - 1) / 4 + 1) + " numbers divide 4 with remainder 1");
            Console.WriteLine("\t" + (n >= 6 ? (n - 6) / 10 + 1 : 0) + " numbers with end digit is 6");
            Console.WriteLine();

            Console.Write(n + "-->");
            for (int i = 2; i * i <= n; ++i)
            {
                while (n % i == 0)
                {
                    Console.Write(i);
                    n /= i;
                    if (n > 1)
                    {
                        Console.Write(".");
                    }
                }
            }
            if (n > 1)
            {
                Console.Write(n);
            }
            Console.WriteLine();
            Console.WriteLine();
        }
    }
}
