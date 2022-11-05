using System;

public class Program
{
    static void Tong(int a, int b)
    {
        Console.WriteLine($"Tong = {a + b}");
    }

    static void UCLN(int n, int m)
    {
        while (n % m != 0)
        {
            (n, m) = (m, n % m);
        }
        Console.WriteLine($"UCLN = {m}");
    }

    static void SoSanh(int k, int l)
    {
        if (k > l)
        {
            Console.WriteLine("k > l");
        }
        if (k < l)
        {
            Console.WriteLine("k < l");
        }
        if (k == l)
        {
            Console.WriteLine("k = l");
        }
    }

    static long GiaiThua(int n)
    {
        if (n <= 1)
        {
            return 1;
        }
        return n * GiaiThua(n - 1);
    }

    delegate void MyDelegate(int a, int b);
    delegate long MyDelegate2(int n);

    static void Main(string[] args)
    {
        Console.WriteLine("Hello World!");

        // khi chua sd delegate
        Console.WriteLine("khi chua sd delegate");
        Tong(4, 6);
        UCLN(4, 6);
        SoSanh(4, 6);

        Tong(24, 6);
        UCLN(24, 6);
        SoSanh(24, 6);

        Tong(4, 16);
        UCLN(4, 16);
        SoSanh(4, 16);

        // khi sd delegate
        Console.WriteLine("khi sd delegate");
        // tao ra delegate cach 1
        MyDelegate m = Tong;
        m += UCLN;
        m += SoSanh;
        m(4, 6);
        m(24, 6);
        m(4, 16);

        MyDelegate2 m2 = GiaiThua;
        Console.WriteLine($"4! = {m2(4)}");

        // tao ra delegate cach 2
        MyDelegate2 m3 = delegate (int n)
        {
            long res = 1;
            for (int i = 2; i <= n; ++i)
            {
                res *= i;
            }
            return res;
        };
        Console.WriteLine($"4! = {m3(4)}");

        // cach 2 su dung lambda
        MyDelegate2 m4 = (int n) =>
        {
            long res = 1;
            for (int i = 2; i <= n; ++i)
            {
                res *= i;
            }
            return res;
        };
        Console.WriteLine($"4! = {m4(4)}");

        // 
        MyDelegate2 m5 = n =>
        {
            long res = 1;
            for (int i = 2; i <= n; ++i)
            {
                res *= i;
            }
            return res;
        };
    }
}
