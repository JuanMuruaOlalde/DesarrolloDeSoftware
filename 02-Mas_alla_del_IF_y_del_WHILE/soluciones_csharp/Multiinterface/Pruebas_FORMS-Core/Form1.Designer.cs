
namespace Pruebas_FORMS_Core
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
            this.lblUnLado = new System.Windows.Forms.Label();
            this.lblOtroLado = new System.Windows.Forms.Label();
            this.btnCalcular = new System.Windows.Forms.Button();
            this.lblPerimetro = new System.Windows.Forms.Label();
            this.lblArea = new System.Windows.Forms.Label();
            this.txtUnLado_valor = new System.Windows.Forms.TextBox();
            this.txtOtroLado_valor = new System.Windows.Forms.TextBox();
            this.txtArea = new System.Windows.Forms.TextBox();
            this.txtPerimetro = new System.Windows.Forms.TextBox();
            this.txtUnLado_unidaddemedida = new System.Windows.Forms.TextBox();
            this.txtOtroLado_unidaddemedida = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // lblUnLado
            // 
            this.lblUnLado.AutoSize = true;
            this.lblUnLado.Location = new System.Drawing.Point(34, 30);
            this.lblUnLado.Name = "lblUnLado";
            this.lblUnLado.Size = new System.Drawing.Size(50, 15);
            this.lblUnLado.TabIndex = 0;
            this.lblUnLado.Text = "un lado:";
            // 
            // lblOtroLado
            // 
            this.lblOtroLado.AutoSize = true;
            this.lblOtroLado.Location = new System.Drawing.Point(34, 60);
            this.lblOtroLado.Name = "lblOtroLado";
            this.lblOtroLado.Size = new System.Drawing.Size(58, 15);
            this.lblOtroLado.TabIndex = 1;
            this.lblOtroLado.Text = "otro lado:";
            // 
            // btnCalcular
            // 
            this.btnCalcular.Location = new System.Drawing.Point(34, 108);
            this.btnCalcular.Name = "btnCalcular";
            this.btnCalcular.Size = new System.Drawing.Size(285, 47);
            this.btnCalcular.TabIndex = 2;
            this.btnCalcular.Text = "Calcular";
            this.btnCalcular.UseVisualStyleBackColor = true;
            this.btnCalcular.Click += new System.EventHandler(this.btnCalcular_Click);
            // 
            // lblPerimetro
            // 
            this.lblPerimetro.AutoSize = true;
            this.lblPerimetro.Location = new System.Drawing.Point(34, 190);
            this.lblPerimetro.Name = "lblPerimetro";
            this.lblPerimetro.Size = new System.Drawing.Size(62, 15);
            this.lblPerimetro.TabIndex = 3;
            this.lblPerimetro.Text = "Perímetro:";
            // 
            // lblArea
            // 
            this.lblArea.AutoSize = true;
            this.lblArea.Location = new System.Drawing.Point(34, 223);
            this.lblArea.Name = "lblArea";
            this.lblArea.Size = new System.Drawing.Size(34, 15);
            this.lblArea.TabIndex = 4;
            this.lblArea.Text = "Área:";
            // 
            // txtUnLado_valor
            // 
            this.txtUnLado_valor.Location = new System.Drawing.Point(90, 27);
            this.txtUnLado_valor.Name = "txtUnLado_valor";
            this.txtUnLado_valor.Size = new System.Drawing.Size(75, 23);
            this.txtUnLado_valor.TabIndex = 5;
            this.txtUnLado_valor.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // txtOtroLado_valor
            // 
            this.txtOtroLado_valor.Location = new System.Drawing.Point(98, 57);
            this.txtOtroLado_valor.Name = "txtOtroLado_valor";
            this.txtOtroLado_valor.Size = new System.Drawing.Size(78, 23);
            this.txtOtroLado_valor.TabIndex = 6;
            this.txtOtroLado_valor.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // txtArea
            // 
            this.txtArea.BackColor = System.Drawing.SystemColors.Info;
            this.txtArea.Enabled = false;
            this.txtArea.Location = new System.Drawing.Point(74, 220);
            this.txtArea.Name = "txtArea";
            this.txtArea.Size = new System.Drawing.Size(114, 23);
            this.txtArea.TabIndex = 7;
            this.txtArea.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // txtPerimetro
            // 
            this.txtPerimetro.BackColor = System.Drawing.SystemColors.Info;
            this.txtPerimetro.Enabled = false;
            this.txtPerimetro.Location = new System.Drawing.Point(102, 187);
            this.txtPerimetro.Name = "txtPerimetro";
            this.txtPerimetro.Size = new System.Drawing.Size(115, 23);
            this.txtPerimetro.TabIndex = 8;
            this.txtPerimetro.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // txtUnLado_unidaddemedida
            // 
            this.txtUnLado_unidaddemedida.Location = new System.Drawing.Point(171, 27);
            this.txtUnLado_unidaddemedida.Name = "txtUnLado_unidaddemedida";
            this.txtUnLado_unidaddemedida.Size = new System.Drawing.Size(33, 23);
            this.txtUnLado_unidaddemedida.TabIndex = 9;
            this.txtUnLado_unidaddemedida.Text = "m";
            // 
            // txtOtroLado_unidaddemedida
            // 
            this.txtOtroLado_unidaddemedida.Location = new System.Drawing.Point(182, 56);
            this.txtOtroLado_unidaddemedida.Name = "txtOtroLado_unidaddemedida";
            this.txtOtroLado_unidaddemedida.Size = new System.Drawing.Size(35, 23);
            this.txtOtroLado_unidaddemedida.TabIndex = 10;
            this.txtOtroLado_unidaddemedida.Text = "m";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(378, 311);
            this.Controls.Add(this.txtOtroLado_unidaddemedida);
            this.Controls.Add(this.txtUnLado_unidaddemedida);
            this.Controls.Add(this.txtPerimetro);
            this.Controls.Add(this.txtArea);
            this.Controls.Add(this.txtOtroLado_valor);
            this.Controls.Add(this.txtUnLado_valor);
            this.Controls.Add(this.lblArea);
            this.Controls.Add(this.lblPerimetro);
            this.Controls.Add(this.btnCalcular);
            this.Controls.Add(this.lblOtroLado);
            this.Controls.Add(this.lblUnLado);
            this.Name = "Form1";
            this.Text = "Pruebas_FORMS-Core   -   CalculoSimple";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblUnLado;
        private System.Windows.Forms.Label lblOtroLado;
        private System.Windows.Forms.Button btnCalcular;
        private System.Windows.Forms.Label lblPerimetro;
        private System.Windows.Forms.Label lblArea;
        private System.Windows.Forms.TextBox txtUnLado_valor;
        private System.Windows.Forms.TextBox txtOtroLado_valor;
        private System.Windows.Forms.TextBox txtArea;
        private System.Windows.Forms.TextBox txtPerimetro;
        private System.Windows.Forms.TextBox txtUnLado_unidaddemedida;
        private System.Windows.Forms.TextBox txtOtroLado_unidaddemedida;
    }
}

