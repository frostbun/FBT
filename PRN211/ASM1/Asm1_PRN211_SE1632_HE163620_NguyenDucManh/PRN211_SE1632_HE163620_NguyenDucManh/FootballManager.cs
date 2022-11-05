using System;
using System.Collections.Generic;
using System.Linq;

namespace PRN211_SE1632_HE163620_NguyenDucManh
{
    public class FootballManager : IManager
    {
        private List<Player> PlayerList { get; } = new();
        private List<Coach> CoachList { get; } = new();

        public void CountCoachesWithMoreThan2YearsOfExperience()
        {
            Console.WriteLine(CoachList.Where(coach => coach.YearsOfExperience >= 3).Count());
        }

        public void InputCoaches()
        {
            do
            {
                string code = CheckData.GetString("Input code: ");
                if (CoachList.Where(p => p.Code == code).Any())
                {
                    Console.WriteLine("Code existed!");
                    continue;
                }
                CoachList.Add(new()
                {
                    Code = code,
                    Name = CheckData.GetString("Input name: "),
                    Address = CheckData.GetString("Input address: "),
                    Position = CheckData.GetString("Input position: "),
                    Salary = CheckData.GetInt("Input salary: "),
                    YearsOfExperience = CheckData.GetInt("Input years of experience: ")
                });
            } while (CheckData.GetString("Do you want to continue? (y/*): ") == "y");
        }

        public void InputPlayers()
        {
            do
            {
                string code = CheckData.GetString("Input code: ");
                if (PlayerList.Where(p => p.Code == code).Any())
                {
                    Console.WriteLine("Code existed!");
                    continue;
                }
                PlayerList.Add(new()
                {
                    Code = code,
                    Name = CheckData.GetString("Input name: "),
                    Address = CheckData.GetString("Input address: "),
                    Position = CheckData.GetString("Input position: "),
                    Salary = CheckData.GetInt("Input salary: "),
                    ShirtNumber = CheckData.GetInt("Input shirt number: ")
                });
            } while (CheckData.GetString("Do you want to continue? (y/*): ") == "y");
        }

        public void ShowCoaches()
        {
            CoachList.ForEach(Console.WriteLine);
        }

        public void ShowMaxSalary()
        {
            Console.WriteLine(Math.Max(
                PlayerList.Max(player => player.Salary),
                CoachList.Max(coach => coach.Salary)
            ));
        }

        public void ShowPlayers()
        {
            PlayerList.ForEach(Console.WriteLine);
        }

        public void SortCoachesWith3YearsOfExperienceBySalaryDescending()
        {
            for (int i = 1; i < CoachList.Count; ++i)
            {
                for (int j = 0; j < i; ++j)
                {
                    Coach c2 = CoachList[i];
                    Coach c1 = CoachList[j];
                    if (c1.YearsOfExperience == 3 && c2.YearsOfExperience == 3 && c1.Salary < c2.Salary)
                    {
                        (CoachList[i], CoachList[j]) = (CoachList[j], CoachList[i]);
                    }
                }
            }
        }

        public void SortPlayersByShirtNumberAscending()
        {
            PlayerList.Sort((p1, p2) => p1.ShirtNumber - p2.ShirtNumber);
        }

        public void SumSalaryOfStrikers()
        {
            Console.WriteLine(PlayerList.Where(player => player.Position.ToLower() == "striker").Sum(player => player.Salary));
        }

        public void Swap2PlayersShirtNumbers()
        {
            string c1 = CheckData.GetString("Input code of player 1: ");
            Player? p1;
            while ((p1 = PlayerList.FirstOrDefault(player => player.Code == c1)) == null)
            {
                Console.WriteLine("Code not found!");
                c1 = CheckData.GetString("Input code of player 1: ");
            }
            string c2 = CheckData.GetString("Input code of player 2: ");
            Player? p2;
            while ((p2 = PlayerList.FirstOrDefault(player => player.Code == c2)) == null || p2.Code == p1.Code)
            {
                Console.WriteLine("Code not found!");
                c2 = CheckData.GetString("Input code of player 2: ");
            }
            if (CheckData.GetString("Do you want to swap? (y/*): ") == "y")
            {
                (p1.ShirtNumber, p2.ShirtNumber) = (p2.ShirtNumber, p1.ShirtNumber);
            }
        }
        
        public void UpdatePlayer()
        {
            Player? player = PlayerList.FirstOrDefault(player => player.Code == CheckData.GetString("Input code: "));
            if (player == null)
            {
                Console.WriteLine("Player not found");
                return;
            }
            int option = CheckData.GetInt("0: Change shirt number\n!=0: Change salary");
            if (option == 0)
            {
                player.ShirtNumber = CheckData.GetInt("Input shirt number: ");
            }
            else
            {
                player.Salary = CheckData.GetInt("Input salary: ");
            }
        }
    }
}
