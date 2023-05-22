/**
 *
 *
 */

checkModal(result);

history.replaceState({}, null, null);

function checkModal(result) {
  if (result === "" || history.state) return;

  if (parseInt(result) > 0) {
    document.querySelector(".modal-body").innerHTML =
      "게시글 " + result + " 번이 등록되었습니다.";
  } else {
    document.querySelector(".modal-body").innerHTML = result;
  }
  $("#registerModal").modal("show");
}

/*
  하단의 페이지 번호 클릭 시 
  a 태그 기본 기능 중지
  a 태그 href 값 가져온후 operForm의 page요소의 value 값으로 세팅
  actionForm 전송
*/
const pagination = document.querySelector(".pagination");
const operForm = document.querySelector("#operForm");

pagination.addEventListener("click", (e) => {
  e.preventDefault();

  //href 값 가져오기
  let href = e.target.getAttribute("href");

  //operForm 안의 page value 수정
  operForm.firstElementChild.value = href;
  //console.log(operForm);

  operForm.submit();
});

// 상단의 amount 수정 시 operForm의 amount요소의 value 값으로 세팅
// actionForm 전송
const amount = document.querySelector("#amount");

amount.addEventListener("change", (e) => {
  //선택한 amount 값 가져오기
  const val = e.target.value;

  const amount = document.querySelector("#operForm input:nth-child(2)");
  amount.value = val;

  operForm.submit();
});

// 제목 클릭 시 a 태그 기능 중지
// operForm 의 action 은  /board/read 변경
// operForm 의 bno 태그를 추가해서 actionForm 전송
const moves = document.querySelectorAll(".move");

moves.forEach((move) => {
  move.addEventListener("click", (e) => {
    e.preventDefault();

    const href = e.target.getAttribute("href");

    const bno = "<input type='hidden' name='bno' value='" + href + "'>";
    operForm.insertAdjacentHTML("beforeend", bno);

    operForm.action = "/board/read";
    //console.log(operForm);
    operForm.submit();
  });
});

//뒤로 가기 이벤트 감지? ==> 새로고침 하기
window.onpageshow = function (event) {
  if (event.persisted) {
    location.reload();
  }
};
