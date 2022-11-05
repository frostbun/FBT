namespace PRN211_SE1632_HE163620_NguyenDucManh
{
    public class Q4
    {
        public static void Run()
        {
            IManager manager = new FootballManager();
            string menu = @"1. Input players
2. Input coaches
3. Show players
4. Show coaches
5. Update player
6. Count Coaches With >= 3 Years Of Experience
7. Show sum salary of Striker
8. Show max salary
9. Sort Players By Shirt Number Ascending
10. Sort Coaches With 3 Years Of Experience By Salary Descending
11. Swap 2 players shirt numbers
0. Exit";

            int option;
            while ((option = CheckData.GetInt(menu)) != 0)
            {
                switch (option)
                {
                    case 1:
                        {
                            manager.InputPlayers();
                            break;
                        }
                    case 2:
                        {
                            manager.InputCoaches();
                            break;
                        }
                    case 3:
                        {
                            manager.ShowPlayers();
                            break;
                        }
                    case 4:
                        {
                            manager.ShowCoaches();
                            break;
                        }
                    case 5:
                        {
                            manager.UpdatePlayer();
                            break;
                        }
                    case 6:
                        {
                            manager.CountCoachesWithMoreThan2YearsOfExperience();
                            break;
                        }
                    case 7:
                        {
                            manager.SumSalaryOfStrikers();
                            break;
                        }
                    case 8:
                        {
                            manager.ShowMaxSalary();
                            break;
                        }
                    case 9:
                        {
                            manager.SortPlayersByShirtNumberAscending();
                            break;
                        }
                    case 10:
                        {
                            manager.SortCoachesWith3YearsOfExperienceBySalaryDescending();
                            break;
                        }
                    case 11:
                        {
                            manager.Swap2PlayersShirtNumbers();
                            break;
                        }
                }
            }
        }
    }
}