using Microsoft.Extensions.Configuration;
using System.Data;
using System.Data.SqlClient;

namespace WinFormsApp2
{
    /// <summary>
    /// Chứa những hàm xử lý database chung cho tất cả
    /// kết nối
    /// executequẻy
    /// </summary>
    public class DataProvider
    {
        //Khai bao cac thanh phan ket noi va xu ly DB
        SqlConnection cnn; //Ket noi DB
        SqlDataAdapter da; //Xu ly cac cau lenh SQL: Select
        SqlCommand cmd; //Thuc thi cau lenh insert,update,delete

        public DataProvider()
        {
            connect();
        }
        private string getConnectionString()
        {
            string connectionString;
            IConfiguration config = new ConfigurationBuilder()
                .SetBasePath(Directory.GetCurrentDirectory())
                .AddJsonFile("appsettings.json", true, true)
                .Build();
            connectionString = config["ConnectionStrings:MySaleDB"];
            return connectionString;
        }
        private void connect()
        {
            try
            {
                string strCnn = getConnectionString();
                cnn = new SqlConnection(strCnn);
                if (cnn.State == ConnectionState.Open)
                {
                    cnn.Close();
                }
                cnn.Open();
                //MessageBox.Show("Connect success!");
            }
            catch (Exception ex)
            {
                MessageBox.Show("Loi ket noi:" + ex.Message);
            }
        }

        //Hàm execute 1 câu lệnh select
        public DataTable executeQuery(string strSelect)
        {
            DataTable dt = new DataTable();
            try
            {
                da = new SqlDataAdapter(strSelect, cnn);
                da.Fill(dt);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Execute fail:" + ex.Message);
            }
            return dt;
        }

        //Hàm execute câu lệnh insert,update,delete
        public bool executeNonQuery(string query, params SqlParameter[] parameters)
        {
            try
            {
                cmd = new SqlCommand(query, cnn);
                cmd.Parameters.AddRange(parameters);
                return cmd.ExecuteNonQuery() > 0;
            }
            catch (Exception ex)
            {
                MessageBox.Show("Insert/Update/Delete error:" + ex.Message);
                return false;
            }
        }

        public IDataReader executeQuery2(string query, params SqlParameter[] parameters)
        {
            try
            {
                cmd = new SqlCommand(query, cnn);
                cmd.Parameters.AddRange(parameters);
                return cmd.ExecuteReader();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Execute fail:" + ex.Message);
                return null;
            }
        }
    }
}
