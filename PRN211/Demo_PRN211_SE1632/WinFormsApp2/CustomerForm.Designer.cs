namespace WinFormsApp2
{
    partial class CustomerForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.tbBirthdate = new System.Windows.Forms.TextBox();
            this.cbID = new System.Windows.Forms.ComboBox();
            this.rbMale = new System.Windows.Forms.RadioButton();
            this.btAdd = new System.Windows.Forms.Button();
            this.dgCustomer = new System.Windows.Forms.DataGridView();
            this.rbFemale = new System.Windows.Forms.RadioButton();
            this.tbName = new System.Windows.Forms.TextBox();
            this.tbAddress = new System.Windows.Forms.TextBox();
            this.btUpdate = new System.Windows.Forms.Button();
            this.btDelete = new System.Windows.Forms.Button();
            this.btReset = new System.Windows.Forms.Button();
            this.btExit = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dgCustomer)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(42, 26);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(134, 30);
            this.label1.TabIndex = 0;
            this.label1.Text = "Customer ID:";
            // 
            // tbBirthdate
            // 
            this.tbBirthdate.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbBirthdate.Location = new System.Drawing.Point(182, 100);
            this.tbBirthdate.Name = "tbBirthdate";
            this.tbBirthdate.Size = new System.Drawing.Size(170, 35);
            this.tbBirthdate.TabIndex = 1;
            // 
            // cbID
            // 
            this.cbID.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.cbID.FormattingEnabled = true;
            this.cbID.Location = new System.Drawing.Point(182, 23);
            this.cbID.Name = "cbID";
            this.cbID.Size = new System.Drawing.Size(170, 38);
            this.cbID.TabIndex = 2;
            this.cbID.SelectedIndexChanged += new System.EventHandler(this.cbID_SelectedIndexChanged);
            // 
            // rbMale
            // 
            this.rbMale.AutoSize = true;
            this.rbMale.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.rbMale.Location = new System.Drawing.Point(559, 101);
            this.rbMale.Name = "rbMale";
            this.rbMale.Size = new System.Drawing.Size(77, 34);
            this.rbMale.TabIndex = 3;
            this.rbMale.TabStop = true;
            this.rbMale.Text = "Male";
            this.rbMale.UseVisualStyleBackColor = true;
            // 
            // btAdd
            // 
            this.btAdd.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btAdd.Location = new System.Drawing.Point(42, 228);
            this.btAdd.Name = "btAdd";
            this.btAdd.Size = new System.Drawing.Size(107, 47);
            this.btAdd.TabIndex = 4;
            this.btAdd.Text = "Add";
            this.btAdd.UseVisualStyleBackColor = true;
            this.btAdd.Click += new System.EventHandler(this.btAdd_Click);
            // 
            // dgCustomer
            // 
            this.dgCustomer.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgCustomer.Location = new System.Drawing.Point(41, 302);
            this.dgCustomer.Name = "dgCustomer";
            this.dgCustomer.RowTemplate.Height = 25;
            this.dgCustomer.Size = new System.Drawing.Size(722, 189);
            this.dgCustomer.TabIndex = 5;
            this.dgCustomer.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgCustomer_CellClick);
            // 
            // rbFemale
            // 
            this.rbFemale.AutoSize = true;
            this.rbFemale.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.rbFemale.Location = new System.Drawing.Point(657, 101);
            this.rbFemale.Name = "rbFemale";
            this.rbFemale.Size = new System.Drawing.Size(97, 34);
            this.rbFemale.TabIndex = 6;
            this.rbFemale.TabStop = true;
            this.rbFemale.Text = "Female";
            this.rbFemale.UseVisualStyleBackColor = true;
            // 
            // tbName
            // 
            this.tbName.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbName.Location = new System.Drawing.Point(550, 23);
            this.tbName.Name = "tbName";
            this.tbName.Size = new System.Drawing.Size(213, 35);
            this.tbName.TabIndex = 7;
            // 
            // tbAddress
            // 
            this.tbAddress.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbAddress.Location = new System.Drawing.Point(182, 162);
            this.tbAddress.Name = "tbAddress";
            this.tbAddress.Size = new System.Drawing.Size(581, 35);
            this.tbAddress.TabIndex = 8;
            // 
            // btUpdate
            // 
            this.btUpdate.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btUpdate.Location = new System.Drawing.Point(196, 228);
            this.btUpdate.Name = "btUpdate";
            this.btUpdate.Size = new System.Drawing.Size(107, 47);
            this.btUpdate.TabIndex = 9;
            this.btUpdate.Text = "Update";
            this.btUpdate.UseVisualStyleBackColor = true;
            this.btUpdate.Click += new System.EventHandler(this.btUpdate_Click);
            // 
            // btDelete
            // 
            this.btDelete.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btDelete.Location = new System.Drawing.Point(351, 228);
            this.btDelete.Name = "btDelete";
            this.btDelete.Size = new System.Drawing.Size(107, 47);
            this.btDelete.TabIndex = 10;
            this.btDelete.Text = "Delete";
            this.btDelete.UseVisualStyleBackColor = true;
            this.btDelete.Click += new System.EventHandler(this.btDelete_Click);
            // 
            // btReset
            // 
            this.btReset.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btReset.Location = new System.Drawing.Point(507, 228);
            this.btReset.Name = "btReset";
            this.btReset.Size = new System.Drawing.Size(107, 47);
            this.btReset.TabIndex = 11;
            this.btReset.Text = "Reset";
            this.btReset.UseVisualStyleBackColor = true;
            this.btReset.Click += new System.EventHandler(this.btReset_Click);
            // 
            // btExit
            // 
            this.btExit.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btExit.Location = new System.Drawing.Point(657, 228);
            this.btExit.Name = "btExit";
            this.btExit.Size = new System.Drawing.Size(107, 47);
            this.btExit.TabIndex = 12;
            this.btExit.Text = "Exit";
            this.btExit.UseVisualStyleBackColor = true;
            this.btExit.Click += new System.EventHandler(this.btExit_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label2.Location = new System.Drawing.Point(375, 26);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(169, 30);
            this.label2.TabIndex = 13;
            this.label2.Text = "Customer Name:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label3.Location = new System.Drawing.Point(74, 103);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(102, 30);
            this.label3.TabIndex = 14;
            this.label3.Text = "Birthdate:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label4.Location = new System.Drawing.Point(459, 103);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(85, 30);
            this.label4.TabIndex = 15;
            this.label4.Text = "Gender:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label5.Location = new System.Drawing.Point(84, 165);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(92, 30);
            this.label5.TabIndex = 16;
            this.label5.Text = "Address:";
            // 
            // CustomerForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(804, 501);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.btExit);
            this.Controls.Add(this.btReset);
            this.Controls.Add(this.btDelete);
            this.Controls.Add(this.btUpdate);
            this.Controls.Add(this.tbAddress);
            this.Controls.Add(this.tbName);
            this.Controls.Add(this.rbFemale);
            this.Controls.Add(this.dgCustomer);
            this.Controls.Add(this.btAdd);
            this.Controls.Add(this.rbMale);
            this.Controls.Add(this.cbID);
            this.Controls.Add(this.tbBirthdate);
            this.Controls.Add(this.label1);
            this.Name = "CustomerForm";
            this.Text = "CustomerForm";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.CustomerForm_FormClosing);
            this.Load += new System.EventHandler(this.CustomerForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgCustomer)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Label label1;
        private TextBox tbBirthdate;
        private ComboBox cbID;
        private RadioButton rbMale;
        private Button btAdd;
        private DataGridView dgCustomer;
        private RadioButton rbFemale;
        private TextBox tbName;
        private TextBox tbAddress;
        private Button btUpdate;
        private Button btDelete;
        private Button btReset;
        private Button btExit;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
    }
}