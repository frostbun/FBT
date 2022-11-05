namespace PRN211_SE1632_HE163620_NguyenDucManh
{
    public interface IManager
    {
        void InputPlayers();
        void InputCoaches();
        void ShowPlayers();
        void ShowCoaches();
        void UpdatePlayer();
        void CountCoachesWithMoreThan2YearsOfExperience();
        void SumSalaryOfStrikers();
        void ShowMaxSalary();
        void SortPlayersByShirtNumberAscending();
        void SortCoachesWith3YearsOfExperienceBySalaryDescending();
        void Swap2PlayersShirtNumbers();
    }
}
