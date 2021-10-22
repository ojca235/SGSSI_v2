# SGSSI_v2
En este repositorio se encuentran dos archivos con codigo fuente en java que permiten minar un bloque que y otro comprobará si se ha hecho bien.

Dentro de la carpeta SHA256_MIN_COMP se encuentran los dos programas más dos bloques que se dan como ejemplo, uno es el original y el otro es ejemplo ya minado.


#General
Para que los programas funcionen correctamente los archivos a minar y a comprobar deben estar en la raiz del proyecto sino los programas dirán que no se ha podido
encontrar el archivo.


#Programa 1 
Sha_Min.java      MD5: 86c5931821e10de9e29177befa4c5ab1

Para elegir el archivo a minar lo que se debe hacer es cambiar la línea 21 "private static final String FICHERO = "SGSSI-21.CB.04.txt";" lo que hay que poner es el 
archivo que se desea minar, y la línea 22 "private static final String GRUPO_ID = "G112029";" hay que sustiur por G + los identificadores del grupo que son hasta
cuatro pares de números.

Por último se puede poner la cantidad de "0" que se desea poner en la línea 77 "if(hash.startsWith("0000")) {" donde se pone el número de "0" que se quiera.

Mostrará por pantalla el hash obtenido más el código en hexadecimal que ha añadido al final para lograr ese resultado.

#Programa 2 
Sha_Comp.java      MD5: c9e00149ce2d56a960e996ea33e0406f

Para elegir los archivo a comprobar lo que se debe hacer es cambiar la línea 21 "private static final String FICHERO = "SGSSI-21.CB.04.txt";" y poner  el 
archivo "original" (archivo que se ha enviado minar) , la línea 22 "private static final String FICHERO1 = "Copia_SGSSI-21.CB.04.txt";  poner  el 
archivo minado.

Mostrará por pantalla un TRUE o un FLASE .
