namespace Q5
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btDelete = new System.Windows.Forms.Button();
            this.btInsert = new System.Windows.Forms.Button();
            this.cbbType = new System.Windows.Forms.ComboBox();
            this.label4 = new System.Windows.Forms.Label();
            this.tbMeaning = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.btUpdate = new System.Windows.Forms.Button();
            this.tbWord = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.dgDict = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.dgDict)).BeginInit();
            this.SuspendLayout();
            // 
            // btDelete
            // 
            this.btDelete.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btDelete.Location = new System.Drawing.Point(640, 182);
            this.btDelete.Name = "btDelete";
            this.btDelete.Size = new System.Drawing.Size(107, 42);
            this.btDelete.TabIndex = 21;
            this.btDelete.Text = "Delete";
            this.btDelete.UseVisualStyleBackColor = true;
            this.btDelete.Click += new System.EventHandler(this.btDelete_Click);
            // 
            // btInsert
            // 
            this.btInsert.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btInsert.Location = new System.Drawing.Point(414, 182);
            this.btInsert.Name = "btInsert";
            this.btInsert.Size = new System.Drawing.Size(107, 42);
            this.btInsert.TabIndex = 20;
            this.btInsert.Text = "Insert";
            this.btInsert.UseVisualStyleBackColor = true;
            this.btInsert.Click += new System.EventHandler(this.btInsert_Click);
            // 
            // cbbType
            // 
            this.cbbType.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.cbbType.FormattingEnabled = true;
            this.cbbType.Location = new System.Drawing.Point(154, 182);
            this.cbbType.Name = "cbbType";
            this.cbbType.Size = new System.Drawing.Size(194, 38);
            this.cbbType.TabIndex = 19;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label4.Location = new System.Drawing.Point(81, 185);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(61, 30);
            this.label4.TabIndex = 18;
            this.label4.Text = "Type:";
            // 
            // tbMeaning
            // 
            this.tbMeaning.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbMeaning.Location = new System.Drawing.Point(508, 109);
            this.tbMeaning.Name = "tbMeaning";
            this.tbMeaning.Size = new System.Drawing.Size(225, 35);
            this.tbMeaning.TabIndex = 17;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label3.Location = new System.Drawing.Point(402, 112);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(100, 30);
            this.label3.TabIndex = 16;
            this.label3.Text = "Meaning:";
            // 
            // btUpdate
            // 
            this.btUpdate.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btUpdate.Location = new System.Drawing.Point(527, 182);
            this.btUpdate.Name = "btUpdate";
            this.btUpdate.Size = new System.Drawing.Size(107, 42);
            this.btUpdate.TabIndex = 15;
            this.btUpdate.Text = "Update";
            this.btUpdate.UseVisualStyleBackColor = true;
            this.btUpdate.Click += new System.EventHandler(this.btUpdate_Click);
            // 
            // tbWord
            // 
            this.tbWord.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbWord.Location = new System.Drawing.Point(154, 109);
            this.tbWord.Name = "tbWord";
            this.tbWord.Size = new System.Drawing.Size(194, 35);
            this.tbWord.TabIndex = 14;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label2.Location = new System.Drawing.Point(80, 112);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(68, 30);
            this.label2.TabIndex = 13;
            this.label2.Text = "Word:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Segoe UI", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(317, 35);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(152, 37);
            this.label1.TabIndex = 12;
            this.label1.Text = "Dictionary";
            // 
            // dgDict
            // 
            this.dgDict.AllowUserToAddRows = false;
            this.dgDict.AllowUserToDeleteRows = false;
            this.dgDict.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgDict.Location = new System.Drawing.Point(42, 253);
            this.dgDict.Name = "dgDict";
            this.dgDict.ReadOnly = true;
            this.dgDict.RowTemplate.Height = 25;
            this.dgDict.Size = new System.Drawing.Size(717, 241);
            this.dgDict.TabIndex = 11;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 533);
            this.Controls.Add(this.btDelete);
            this.Controls.Add(this.btInsert);
            this.Controls.Add(this.cbbType);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.tbMeaning);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.btUpdate);
            this.Controls.Add(this.tbWord);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.dgDict);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgDict)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Button btDelete;
        private Button btInsert;
        private ComboBox cbbType;
        private Label label4;
        private TextBox tbMeaning;
        private Label label3;
        private Button btUpdate;
        private TextBox tbWord;
        private Label label2;
        private Label label1;
        private DataGridView dgDict;
    }
}