package reb.or.kr.app3_communityapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import reb.or.kr.app3_communityapp.databinding.BoardMainRecyclerItemBinding
import reb.or.kr.app3_communityapp.databinding.FragmentBoardMainBinding


class BoardMainFragment : Fragment() {

    lateinit var boardMainFragmentBinding:FragmentBoardMainBinding

    val boardlistData=arrayOf(
        "전체글","게시판1","게시판2","게시판3","게시판4"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        boardMainFragmentBinding = FragmentBoardMainBinding.inflate(inflater)
        boardMainFragmentBinding.boardMainToolbar.title="게시판이름"

        boardMainFragmentBinding.boardMainToolbar.inflateMenu(R.menu.board_main_menu)
        boardMainFragmentBinding.boardMainToolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.board_main_menu_board_list->{
                    val boardListBuilder = AlertDialog.Builder(requireContext())
                    boardListBuilder.setTitle("게시판 목록")
                    boardListBuilder.setNegativeButton("취소",null)
                    boardListBuilder.setItems(boardlistData,null)
                    boardListBuilder.show()
                    true
                }
                else->false
            }
        }

        val boardMainRecyclerAdapter=BoardMainRecyclerAdapter()
        boardMainFragmentBinding.boardMainRecycler.adapter=boardMainRecyclerAdapter

        boardMainFragmentBinding.boardMainRecycler.layoutManager=LinearLayoutManager(requireContext())
        boardMainFragmentBinding.boardMainRecycler.addItemDecoration(DividerItemDecoration(requireContext(),1))

        return boardMainFragmentBinding.root
    }
    inner class BoardMainRecyclerAdapter : RecyclerView.Adapter<BoardMainRecyclerAdapter.ViewHolderClass>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            val boardMainRecyclerItemBinding=BoardMainRecyclerItemBinding.inflate(layoutInflater)
            val holder = ViewHolderClass(boardMainRecyclerItemBinding)

            val layoutParams=RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            boardMainRecyclerItemBinding.root.layoutParams=layoutParams
            boardMainRecyclerItemBinding.root.setOnClickListener(holder)
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        }

        override fun getItemCount(): Int {
            return 10
        }

        inner class ViewHolderClass(boardMainRecyclerItemBinding: BoardMainRecyclerItemBinding)
            :RecyclerView.ViewHolder(boardMainRecyclerItemBinding.root),View.OnClickListener{
                override fun onClick(p0: View?) {

                }
            }
    }
}