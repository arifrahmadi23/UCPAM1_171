package com.example.ucp1

import android.preference.PreferenceActivity.Header
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun UCP(modifier: Modifier = Modifier){
    Column (modifier = modifier .fillMaxSize())
    {
        TampilanHeader()
        Biodata()
    }
}

@Composable
fun TampilanHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF0D92F4))
            .padding(20.dp)

    ) {
        Row(modifier = Modifier, verticalAlignment = Alignment.Top )
        {

            Column(
                modifier = Modifier

            ) {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = null,
                    modifier = Modifier
                        .size(28.dp),

                    tint = Color.White,
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = "Halo,",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    modifier = Modifier
                        .padding(3.dp)

                )
                Text(
                    text = "Muhammad Arif",
                    color = Color.White,
                    fontSize = 25.sp
                )
            }





                Image(
                    painterResource(R.drawable.fotosaya),


                    modifier = Modifier

                        .size(100.dp),

                    contentDescription = null
                )

            }
        }

    }


@Composable
fun Biodata () {
    var nama by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }

    var dataNama by remember { mutableStateOf("") }
    var dataNoHp by remember { mutableStateOf("") }

    var jenisK by remember { mutableStateOf("") }
    var simpanJenisK by remember { mutableStateOf("") }
    val dataJK = listOf("Laki - Laki", "Perempuan")



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            "Yuk lengkapi data dirimu !",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.padding(5.dp))
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            placeholder = { Text("Masukkan Nama Anda") }
        )
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            value = noHp,
            onValueChange = { noHp = it },
            label = { Text("No Handphone") },
            placeholder = { Text("Masukkan No Handphone Anda") }
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            "Jenis Kelamin",

            fontSize = 15.sp
        )
        Row(
            modifier = Modifier.padding(3.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            dataJK.forEach { selectedJK ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(5.dp)
                )
                {
                    RadioButton(selected = jenisK == selectedJK,
                        onClick = {
                            jenisK = selectedJK
                        })
                    Text(selectedJK)
                }
            }
        }
        Button(

            onClick = {
                dataNama = nama
                dataNoHp = noHp
                simpanJenisK = jenisK
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)


        ) {
            Text("Simpan")
        }
        Column (modifier = Modifier) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            {
                Column {

                    TampilData(
                        judul = "Nomor Handphone",
                        isinya = dataNoHp
                    )
                    TampilData(
                        judul = "Jenis Kelamin",
                        isinya = simpanJenisK
                    )
                }
            }
        }


    }
}

@Composable
fun TampilData(
    judul :String,
    isinya :String
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya, modifier = Modifier.weight(2f))
    }
}
