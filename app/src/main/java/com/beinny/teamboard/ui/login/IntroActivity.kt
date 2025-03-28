package com.beinny.teamboard.ui.login

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.WindowManager
import com.beinny.teamboard.databinding.ActivityIntroBinding
import com.beinny.teamboard.ui.base.BaseActivity

class IntroActivity : BaseActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 전체 화면
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // 폰트 설정
        val typeface: Typeface = Typeface.createFromAsset(assets, "carbon bl.ttf")
        binding.tvIntroAppName.typeface = typeface

        binding.btnIntroSignIn.setOnClickListener {
            startActivity(Intent(this@IntroActivity, SignInActivity::class.java))
        }

        binding.btnIntroSignUp.setOnClickListener {
            startActivity(Intent(this@IntroActivity, SignUpActivity::class.java))
        }
    }
}