package com.example.myapplication
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.core.widget.*
import android.widget.*
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.dialogfragment.CustomDialogClass
import com.example.dialogfragment.CustomDialogClass2
import kotlin.math.pow

//import com.google.android.material.navigation.NavigationBarView
class MainActivity : AppCompatActivity() {
    var z : Int = 0
    var num :Int =0
    var Sal : Double=0.0
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val background: ConstraintLayout = findViewById(R.id.background)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val button: Button = findViewById(R.id.btResult)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)
        //global variable
        var flag : String = ""
        val spinnerVal : Spinner = findViewById(R.id.spinnerV)


        when(item.itemId){
            R.id.item1 ->{

                if(z==0){
                    background.setBackgroundColor(Color.parseColor("#FFFFFF"))
                    Toast.makeText(this, "White", Toast.LENGTH_SHORT).show()
                    z++}
                else if(z==1){
                    background.setBackgroundColor(Color.parseColor("#FF0000"))
                    Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show()
                    z++}
                else if(z==2){
                    background.setBackgroundColor(Color.parseColor("#008000"))
                    Toast.makeText(this, "Green", Toast.LENGTH_SHORT).show()
                    z++}
                else if(z==3){
                    background.setBackgroundColor(Color.parseColor("#0000FF"))
                    Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show()
                    z++}
                else if(z==4){
                    background.setBackgroundColor(Color.parseColor("#FFFF00"))
                    Toast.makeText(this, "Yellow", Toast.LENGTH_SHORT).show()
                    z++}
                else if(z==5){
                    background.setBackgroundColor(Color.parseColor("#FFA500"))
                    Toast.makeText(this, "Orange", Toast.LENGTH_SHORT).show()
                    z++}
                else if(z==6){
                    background.setBackgroundColor(Color.parseColor("#9370DB"))
                    Toast.makeText(this, "Purple", Toast.LENGTH_SHORT).show()
                    z++}
                else if(z==7){
                    background.setBackgroundColor(Color.parseColor("#FFC0CB"))
                    Toast.makeText(this, "Pink", Toast.LENGTH_SHORT).show()
                    z++}

                if (z>=7){z=0}

            }

            R.id.item2 ->{
                Toast.makeText(this, "Main Calculator", Toast.LENGTH_SHORT).show()
                var options = arrayOf("sum","multiply","division","subtraction","root","power")
                spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
                button.setOnClickListener{ view ->
                    //code here
                    var x: Float = edtxt1.text.toString().toFloat();
                    var y: Float = edtxt2.text.toString().toFloat();

                    if(flag =="sum")
                        resultTV.text = sum(x,y).toString();
                    else if (flag =="multiply")
                        resultTV.text = multiply(x,y).toString();
                    else if (flag =="division"){
                        if(division(x,y)==9.999999){
                            Toast.makeText(this, "Divide by zero is not acceptable",Toast.LENGTH_LONG).show()
                            resultTV.text ="Math Error"        }
                        else {resultTV.text = division(x,y).toString();}


                    }
                    else if (flag =="subtraction")
                        resultTV.text = subtraction(x,y).toString();
                    else if (flag =="root")
                        resultTV.text = root(x,y).toString();
                    else if (flag =="power")
                        resultTV.text = power(x,y).toString();
                }
                spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        flag = options.get(p2) //p2 is the index of selected item
                    }
                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
            }
            R.id.item3 ->{
                Toast.makeText(this, "Converting Weight", Toast.LENGTH_SHORT).show()
                var options = arrayOf("Gram to Bound","Gram to Ounce","Gram to Mithqal","Gram to Dirham","Gram to Chickpea","Gram to Carat","Gram to Sou")
                spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
                button.setOnClickListener{ view ->
                    //code here
                    var x: Float = edtxt1.text.toString().toFloat();
                    var y: Double
                    if(flag =="Gram to Bound"){
                        y= 450.0
                        resultTV.text = division2(x,y).toString()}
                    else if (flag =="Gram to Ounce"){
                        y= 37.5
                        resultTV.text = division2(x,y).toString()}
                    else if (flag =="Gram to Mithqal"){
                        y=4.68
                       resultTV.text = division2(x,y).toString();}
                    else if (flag =="Gram to Dirham"){
                        y=3.125
                        resultTV.text = division2(x,y).toString();}
                    else if (flag =="Gram to Chickpea"){
                        y=1.17
                        resultTV.text = division2(x,y).toString();}
                    else if (flag =="Gram to Carat"){
                        y=0.198
                        resultTV.text = division2(x,y).toString();}
                    else if (flag =="Gram to Sou"){
                        y=0.525
                        resultTV.text = division2(x,y).toString();}
                }
                spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        flag = options.get(p2) //p2 is the index of selected item
                    }
                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
            }
            R.id.item4 ->{
                Toast.makeText(this, "Converting Lengtha", Toast.LENGTH_SHORT).show()
                var options = arrayOf("Cm to Meter","Cm to Kilometer","Cm to Hectometer","Cm to Decimeter","Cm to Nautical Mile","Cm to Mile","Cm to Furlong","Cm to Kasbah","Cm to Tall","Cm to Yard","Cm to Foot","Cm to Inch")
                spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
                button.setOnClickListener { view ->
                    //code here
                    var x: Float = edtxt1.text.toString().toFloat();
                    var y: Double
                    when (flag) {
                        "Cm to Meter" -> {
                            y = 100.0
                            resultTV.text = division2(x, y).toString()
                        }
                        "Cm to Kilometer" -> {
                            y = 100000.0
                            resultTV.text = division2(x, y).toString()
                        }
                        "Cm to Hectometer" -> {
                            y = 10000.0
                            resultTV.text = division2(x, y).toString();
                        }
                        "Cm to Decimeter" -> {
                            y = 1000.0
                            resultTV.text = division2(x, y).toString();
                        }
                        "Cm to Nautical Mile" -> {
                            y = 185200.0
                            resultTV.text = division2(x, y).toString();
                        }
                        "Cm to Mile" -> {
                            y = 160934.0
                            resultTV.text = division2(x, y).toString();
                        }
                        "Cm to Furlong" -> {
                            y = 20100.0
                            resultTV.text = division2(x, y).toString();
                        }
                        "Cm to Kasbah" -> {
                            y = 502.9
                            resultTV.text = division2(x, y).toString();
                        }
                        "Cm to Tall" -> {
                            y = 182.8
                            resultTV.text = division2(x, y).toString();
                        }
                        "Cm to Yard" -> {
                            y = 91.44
                            resultTV.text = division2(x, y).toString();
                        }
                        "Cm to Foot" -> {
                            y = 30.48
                            resultTV.text = division2(x, y).toString();
                        }
                        "Cm to Inch" -> {
                            y = 2.54
                            resultTV.text = division2(x, y).toString();
                        }
                    }
                }
                spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        flag = options.get(p2) //p2 is the index of selected item
                    }
                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
            }
            R.id.item5 ->{
                if(edtxt1.text.toString()!=""){
                    Sal= edtxt1.text.toString().toDouble();}
                else{Sal=0.0}
                var dialog_var= CustomDialogClass2()
                dialog_var.show(supportFragmentManager, "Custom Dialog")
                Toast.makeText(this, "Converting Currency", Toast.LENGTH_SHORT).show()
            }

            R.id.item6 ->{
                if(edtxt1.text.toString()!=""){
                num= edtxt1.text.toString().toInt();}
                else{num=0}
                var dialog_var= CustomDialogClass()
                dialog_var.show(supportFragmentManager, "Custom Dialog")
                Toast.makeText(this, "Converting Number", Toast.LENGTH_SHORT).show()
            }

        }
        return true;}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun receiveFeedback(feedback : String) {
        when (feedback) {
            "Hex" -> {
            }
            "Bin" -> {
                var x=num
                var binaryN = 0
                var count = 0
                while (x != 0) {
                    val rem = x % 2
                    val c = 10.toDouble().pow(count)
                    binaryN += (rem * c).toInt()

                    x /= 2
                    count++
                }

                val ratingTV: TextView=findViewById(R.id.textResult)
                ratingTV.text=binaryN.toString();
                ratingTV.toString()

            }
            "Oct" -> {
                var decimal = num
                var octalNumber = 0
                var i = 1

                while (decimal != 0) {
                    octalNumber += decimal % 8 * i
                    decimal /= 8
                    i *= 10
                }
                val ratingTV: TextView=findViewById(R.id.textResult)
                ratingTV.text=octalNumber.toString();
                ratingTV.toString()


            }
            "Jordanian dinar to US dollar"->{
                var Jd = Sal
                Jd= (Jd*0.71).toDouble()
                val ratingTV: TextView=findViewById(R.id.textResult)
                ratingTV.text=Jd.toString();
                ratingTV.toString()
            }
            "Jordanian dinar to the European euro"->{
                var Jd = Sal
                Jd= (Jd*0.78).toDouble()
                val ratingTV: TextView=findViewById(R.id.textResult)
                ratingTV.text=Jd.toString();
                ratingTV.toString()
            }
            "Jordanian dinar to UAE dirham"->{
                var Jd = Sal
                Jd= (Jd*0.19).toDouble()
                val ratingTV: TextView=findViewById(R.id.textResult)
                ratingTV.text=Jd.toString();
                ratingTV.toString()
            }
            "Jordanian dinar to Saudi riyal"->{
                var Jd = Sal
                Jd= (Jd*0.19).toDouble()
                val ratingTV: TextView=findViewById(R.id.textResult)
                ratingTV.text=Jd.toString();
                ratingTV.toString()
            }
            "Jordanian dinar to Egyptian pound"->{
                var Jd = Sal
                Jd= (Jd*0.039).toDouble()
                val ratingTV: TextView=findViewById(R.id.textResult)
                ratingTV.text=Jd.toString();
                ratingTV.toString()
            }
            "Jordanian dinar to Sterling pound"->{
                var Jd = Sal
                Jd= (Jd*0.93).toDouble()
                val ratingTV: TextView=findViewById(R.id.textResult)
                ratingTV.text=Jd.toString();
                ratingTV.toString()
            }

        }
    }

}
public fun sum(a: Float, b: Float): Float {
    return a+b
}
public fun multiply(a: Float, b: Float): Float {
    return a*b
}
public fun division(a: Float, b: Float): Double {
    if(b.toInt()!=0){
        return a.toDouble()/b}
    else{
        return 9.999999}
}
public fun subtraction(a: Float, b: Float): Float {
    return a-b
}
public fun root(a: Float, b: Float): Double {
    return Math.sqrt(a.toDouble())
}
public fun power(a: Float, b: Float): Double {
    return Math.pow(a.toDouble(), b.toDouble())
}
public fun division2(a: Float, b: Double): Double {
        return a.toDouble()/b
}
