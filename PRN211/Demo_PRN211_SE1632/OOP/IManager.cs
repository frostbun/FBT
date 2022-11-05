namespace OOP
{
    public interface IManager
    {
        void ShowList();
        void InputList();
        void Update(string code);
        void Delete(string code);
        void SaveFile();
        void LoadFile();
        void Exit();
    }
}