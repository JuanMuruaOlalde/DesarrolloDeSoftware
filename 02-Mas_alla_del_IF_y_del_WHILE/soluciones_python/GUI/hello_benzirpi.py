import tkinter as tk

def saludar():
    saludo["text"] = "Hola, " + nombre.get()


ventana = tk.Tk()
ventana.title("Hello...")

contenedor = tk.Frame()
contenedor.pack(padx=5, pady=5)

nombre_lbl = tk.Label(master=contenedor, text="Teclear aquí un nombre:")
nombre = tk.Entry(master=contenedor)
nombre_lbl.grid(row=0, column=0, sticky="e", padx=5)
nombre.grid(row=0, column=1)

saludar = tk.Button(
    master=contenedor, 
    text="Clic aquí para saludar",
    command=saludar)
saludar.grid(row=0, column=2, padx=10, pady=5)

saludo = tk.Label(master=contenedor, width=30)
saludo.grid(row=0, column=3)


def arrancar():
    ventana.mainloop()