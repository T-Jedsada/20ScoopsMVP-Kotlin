package tweentyscoops.mvp.kotlin.ui.main.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.fragment_main.*
import tweentyscoops.mvp.kotlin.R
import tweentyscoops.mvp.kotlin.di.ApplicationComponent
import tweentyscoops.mvp.kotlin.extensions.navigate
import tweentyscoops.mvp.kotlin.ui.base.BaseFragment
import tweentyscoops.mvp.kotlin.ui.listrepos.ListReposActivity
import tweentyscoops.mvp.kotlin.ui.viewpager.ViewPagerActivity

class MainFragment : BaseFragment<MainContract.View, MainPresenter>(),
        MainContract.View {

    companion object {
        fun newInstance(bundle: Bundle? = null): MainFragment {
            val mainFragment = MainFragment()
            mainFragment.arguments = bundle
            return mainFragment
        }
    }

    override fun layoutToInflate() = R.layout.fragment_main

    override fun doInjection(appComponent: ApplicationComponent) {
        appComponent.inject(this)
    }

    override fun startView() {

    }

    override fun stopView() {

    }

    override fun bindView(view: View?) {
        et_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter.sendText(p0.toString())
            }
        })

        btn_view_pager.setOnClickListener { activity.navigate<ViewPagerActivity>() }

        btn_list_repos_loadmore.setOnClickListener { activity.navigate<tweentyscoops.mvp.kotlin.ui.listreposloadmore.ListReposActivity>() }

        btn_list_repos.setOnClickListener { activity.navigate<ListReposActivity>() }
    }

    override fun setupInstance() {

    }

    override fun setupView() {

    }

    override fun initialize() {

    }

    override fun saveInstanceState(outState: Bundle?) {

    }

    override fun restoreView(savedInstanceState: Bundle?) {

    }
}