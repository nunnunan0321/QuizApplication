package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.util.Random

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val random = Random()
        val btn_quiz_save: Button = findViewById(R.id.btn_quiz_save)
        val question_view: TextView =findViewById(R.id.question_view)
        val example_1: Button =findViewById(R.id.example_1)
        val example_2: Button =findViewById(R.id.example_2)
        val example_3: Button =findViewById(R.id.example_3)
        val example_4: Button = findViewById(R.id.example_4)
        val result: TextView = findViewById(R.id.result)

        var result_uncorrect=0
        var result_corret=0
        val question= arrayOf("문제1 ","문제2 ","문제3","문제4","문제5","문제6","문제7","문제8","문제9","문제10","문제11","문제12","문제13","문제14","문제15","문제16","문제17","문제18","문제19","문제20")
        val answer= arrayOf("답1","답2","답3","답4","답5","답6","답7","답8","답9","답10","답11","답12","답13","답14","답15","답16","답17","답18","답19","답20")
        var example= arrayOf("예시1","예시2","예시3","예시4","예시5","예시6","예시7","예시8","예시9","예시10","예시11","예시12","예시13","예시14","예시15","예시16","예시17","예시18","예시19","예시20")
        var contin=0 //연속으로 맞춘 문제 수


        /*fun<T> find(a:Array<T>,Target: T):Int {//인덱스 구하는 함수
            for (i in a.indices) {
                if(a[i]==Target) return i
            }
            return -1
        }*/

        fun new(){//문제 텍스트뷰, 예시, 정답 버튼 텍스트 바꿔주는 함수
            val answer_place=random.nextInt(4)//정답이 위치할 자리 선정
            val question_number=random.nextInt(20)//제출할 문제 선정
            //result.text="맞춘 문제 ${result_corret}개 / 푼 문제 ${result_uncorrect}개"
            question_view.text = question[question_number]//문제 출력

/*
    var num:Int=random.nextInt(20)
    w@for(item in 0..4){
    if(num==question_number||num==example[item])
    {
        num+=1
        continue@w
    }
    else
    {
        return num
    }
    }
 */
            fun fill_example():Int{//예시설정 함수
                var num:Int=random.nextInt(20)
                w@for(item in 0..3){
                    if(num==question_number||example[num]==example[item])//다른 예시의 값과 같지 않고 답의 값과 같지 않은 예시를 설정
                    {
                        num+=1
                        continue@w
                    }
                }
                return num
            }

                if(answer_place==0) {//정답 위치가 0이면 첫번째 예시 텍스트를 정답으로 설정 및 다른 예시 채우기
                    example_1.text = answer[question_number]
                    example_2.text = example[fill_example()]
                    example_3.text = example[fill_example()]
                    example_4.text = example[fill_example()]
                }
                if(answer_place==1) {//정답 위치가 1이면 두번째 예시 텍스트를 정답으로 설정 및 다른 예시 채우기
                    example_1.text = example[fill_example()]
                    example_2.text = answer[question_number]
                    example_3.text = example[fill_example()]
                    example_4.text = example[fill_example()]
                }
                if(answer_place==2) {//정답 위치가 2면 세번째 예시 텍스트를 정답으로 설정 및 다른 예시 채우기
                    example_1.text = example[fill_example()]
                    example_2.text = example[fill_example()]
                    example_3.text = answer[question_number]
                    example_4.text = example[fill_example()]
                }
                if(answer_place==3) {//정답 위치가 3이면 네번째 예시 텍스트를 정답으로 설정 및 다른 예시 채우기
                    example_1.text = example[fill_example()]
                    example_2.text = example[fill_example()]
                    example_3.text = example[fill_example()]
                    example_4.text = answer[question_number]
                }

        }

//        find<String>(answer, example_1.text as String)
        //random.nextInt(5)
        new()//초기 화면 구성


        fun find_index(a:Array<String>,b:String):Int{
            var index:Int=0
            for(item in 0..19){
                if(a[item]==b){
                    index=item
                }
            }
            return index
        }//인덱스 찾기

        fun showSnackbar(view: View,a: Int):Unit {
            if (a % 50 == 0 && a != 0) Snackbar.make(view, "${a}연속 정답입니다!", Snackbar.LENGTH_SHORT).show()
            else Snackbar.make(view, "정답입니다!", Snackbar.LENGTH_SHORT).show()
            //actionSnackbar.setTextColor(resources.getColor(android.R.color.holo_orange_light, theme))
            //actionSnackbar.setActionTextColor(resources.getColor(android.R.color.holo_blue_bright, theme))
            //actionSnackbar.setBackgroundTint(resources.getColor(android.R.color.holo_red_dark, theme))
        }

        example_1.setOnClickListener(){
            var answer_index=find_index(question,question_view.text.toString()) //현재 문제의 인덱스를 가져와 정답 인덱스를 알아냅니다.
            val example_number=find_index(answer,example_1.text.toString()) //example_1의 텍스트가 answer 배열에서 몇번째 인덱스인지 알아냅니다.
            if(example_number==answer_index){   //정답일 때(example_number가 answer_index와 같을 때)
                //print()
                contin+=1   //contin에 1을 더합니다(contin은 연속 정답 횟수를 알기 위해 사용하는 변수)
                showSnackbar(result,contin) //정답 여부와 연속 정답 횟수를 스낵바로 띄워주는 함수
                result_corret+=1    //맞춘 문제에 1을 더합니다.
                new()   //새로 퀴즈 화면을 구성합니다

            }
            else {  //정답이 아닐 때(example_number가 answer_index와 다를 때)
                contin=0    //연속 정답 횟수를 0으로 초기화합니다
                showSnackbar(result,contin) //정답 여부와 연속 정답 횟수를 스낵바로 띄워주는 함수
                result_uncorrect+=1 //틀린 횟수에 1을 더합니다.
            }
            result.text="맞춘 문제 ${result_corret}개 / 틀린 횟수 ${result_uncorrect}개"  //result의 텍스트를 업데이트 해줍니다.
            }
        example_2.setOnClickListener(){
            var answer_index=find_index(question,question_view.text.toString())
            val example_number=find_index(answer,example_2.text.toString())
            if(example_number==answer_index){
                contin+=1
                showSnackbar(result,contin)
                result_corret+=1
                new()

            }
            else {
                contin=0
                showSnackbar(result,contin)
                result_uncorrect+=1
            }
            result.text="맞춘 문제 ${result_corret}개 / 틀린 횟수 ${result_uncorrect}개"
        }
        example_3.setOnClickListener(){
            var answer_index=find_index(question,question_view.text.toString())
            val example_number=find_index(answer,example_3.text.toString())
            if(example_number==answer_index){
                contin+=1
                showSnackbar(result,contin)
                result_corret+=1
                new()

            }
            else {
                contin=0
                showSnackbar(result,contin)
                result_uncorrect+=1
            }
            result.text="맞춘 문제 ${result_corret}개 / 틀린 횟수 ${result_uncorrect}개"
        }
        example_4.setOnClickListener(){
            var answer_index=find_index(question,question_view.text.toString())
            val example_number=find_index(answer,example_4.text.toString())
            if(example_number==answer_index){
                contin+=1
                showSnackbar(result,contin)
                result_corret+=1
                new()
            }
            else {

                contin=0
                showSnackbar(result,contin)
                result_uncorrect+=1
            }
            result.text="맞춘 문제 ${result_corret}개 / 틀린 횟수 ${result_uncorrect}개"
        }
            var count=0

        btn_quiz_save.setOnClickListener(){
            if(count==10){
                count=0
                Toast.makeText(this,"저장한도가 찼습니다\n처음 저장한 문제와 자리를 바꿉니다",Toast.LENGTH_SHORT).show()
            }
            Toast.makeText(this, "저장되었습니다!", Toast.LENGTH_SHORT).show()

            val intent=Intent(this,CollectionActivity::class.java)
            intent.putExtra("questionList${count}",question_view.text.toString())
            //startActivity(intent)
            //finish()
        }


        }

    }






