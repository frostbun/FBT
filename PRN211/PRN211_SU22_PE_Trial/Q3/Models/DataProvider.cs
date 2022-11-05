using System.Data;
using System.Data.SqlClient;

namespace Q3.Models
{
    public class DataProvider
    {
        private SqlConnection conn;

        public DataProvider()
        {
            conn = new SqlConnection(GetConnectionString());
            if (conn.State == ConnectionState.Open)
            {
                conn.Close();
            }
            conn.Open();
        }

        private static string GetConnectionString()
        {
            var config = new ConfigurationBuilder()
                .SetBasePath(Directory.GetCurrentDirectory())
                .AddJsonFile("appsettings.json", true, true)
                .Build();
            return config.GetConnectionString("PE_PRN_Sum21");
        }

        public IDataReader ExecuteQuery(string query, params SqlParameter[] parameters)
        {
            var cmd = new SqlCommand(query, conn);
            cmd.Parameters.AddRange(parameters);
            return cmd.ExecuteReader();
        }

        public bool ExecuteNonQuery(string query, params SqlParameter[] parameters)
        {
            var cmd = new SqlCommand(query, conn);
            cmd.Parameters.AddRange(parameters);
            return cmd.ExecuteNonQuery() > 0;
        }
    }
}
