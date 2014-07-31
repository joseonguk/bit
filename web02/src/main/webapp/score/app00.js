window.onload = function() {
  loadScoreList();

  $("#btnUpdate").click(updateScore);
  $("#btnReset").click(resetForm);

  $("#btnDelete").click(function(event) {
    deleteScore(document.getElementById("no").value);
  });

  $("#btnAdd").click(addScore);
};

function resetForm() {
  changeFormState("newState");
}

function changeFormState(state) {
  var elements = $(".x-update-item");
  if (state == "updateState") {
    elements.css("display", "");
  } else {
    elements.css("display", "none");
  }

  elements = $(".x-new-item");
  if (state == "updateState") {
    elements.css("display", "none");
  } else {
    elements.css("display", "");
  }
}

function addScore(event) {
  event.preventDefault();
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(event) {
    if (xhr.readyState == 4) {
      location.href = "app.html";
    }
  };
  xhr.open('POST', 'add.json', true);
  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  var data = "name=" + encodeURIComponent($("#name").val()) 
      + "&kor=" + $("#kor").val()
      + "&eng=" + $("#eng").val()
      + "&math=" + $("#math").val() 
      + "&execDate=" + $("#execDate").val();
  xhr.send(data);
}

function updateScore(event) {
  event.preventDefault();
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(event) {
    if (xhr.readyState == 4) {
      location.href = "app.html";
    }
  };
  xhr.open('POST', 'update.json', true);

  // 전송 데이터 형식이 폼 데이터임을 알려야 한다.
  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

  // 서버에 보낼 데이터 준비
  // ASCII가 아닌 문자는 모두 URL 인코딩 해야 한다.
  var data = "no=" + $("#no").val()
    + "&name=" + encodeURIComponent($("#name").val()) 
    + "&kor=" + $("#kor").val()
    + "&eng=" + $("#eng").val()
    + "&math=" + $("#math").val() 
    + "&execDate=" + $("#execDate").val();

  xhr.send(data);
}

function deleteScore(no) {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(event) {
    if (xhr.readyState == 4) {
      var result = JSON.parse(xhr.responseText);

      if (result.status == "success") {
        alert("삭제 성공입니다.");
        location.href = "app.html";
      } else {
        alert("삭제 실패하였습니다.");
      }
    }
  };

  xhr.open('GET', "delete.json?no=" + no, true);
  xhr.send(null);
}

function loadScoreDetail(event) {
  event.preventDefault(); // 웹 브라우저야, a 태그를 클릭할 때 수행하는 기본 작업을 하지 말아라!

  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(event) {
    if (xhr.readyState == 4) {
      // JSON 형식의 문자열을 실행하여 자바스크립트 객체를 생성한다.
      var score = JSON.parse(xhr.responseText);

      // 서버로부터 받은 정보를 가지고 입력폼에 값을 설정한다.
      $("#no").val(score.no);
      $("#name").val(score.name);
      $("#kor").val(score.kor);
      $("#eng").val(score.eng);
      $("#math").val(score.math);
      $("#execDate").val(new Date(score.execDate).toString("yyyy-MM-dd"));

      // 성적 폼의 상태를 변경 폼 상태로 바꾼다.
      changeFormState("updateState");
    }
  };
  xhr.open('GET', this.href, true);
  xhr.send(null);
}

function loadScoreList() {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(event) {
    if (xhr.readyState == 4) {
      // 1. 서버로부터 받은 JSON 문자열을 실행하여 자바스크립트 객체로 만든다.
      var scores = eval('(' + xhr.responseText + ')');

      // 2. 배열을 반복하면서 성적정보 출력
      var table = $("#scoreTable");
      var tr, td, a;
      for ( var i in scores) {
        scores[i].total = scores[i].kor + scores[i].eng + scores[i].math;
        scores[i].average = scores[i].total / 3;

        tr = $("<tr>"); // <tr></tr>
        table.append(tr); // <table>...<tr></tr></table>

        td = $("<td>"); // <td></td>
        a = $("<a>")
            .attr('href', 'update.json?no=' + scores[i].no)
            .text(scores[i].no)
            .click(loadScoreDetail);
        td.append(a); // <td><a>...</a></td>
        tr.append(td); // <tr><td>...</td></tr>

        td = $("<td>");
        td.text(new Date(scores[i].execDate).toString("yyyy-MM-dd"));
        tr.append(td);

        td = $("<td>");
        td.text(scores[i].name);
        tr.append(td);

        td = $("<td>");
        td.text(scores[i].kor);
        tr.append(td);

        td = $("<td>");
        td.text(scores[i].eng);
        tr.append(td);

        td = $("<td>");
        td.text(scores[i].math);
        tr.append(td);

        td = $("<td>");
        td.text(scores[i].total);
        tr.append(td);

        td = $("<td>");
        td.text(scores[i].average);
        tr.append(td);

        td = $("<td>");
        a = $("<a>");
        a.attr("data-no", scores[i].no);
        a.text('삭제');
        a.attr("class", "btn btn-danger btn-xs");
        a.onclick = function(event) {
          event.preventDefault();
          deleteScore(this.getAttribute("data-no"));
        };
        td.append(a);
        tr.append(td);
      }
    }
  };

  xhr.open('GET', 'list.json', true);
  xhr.send(null);
}
