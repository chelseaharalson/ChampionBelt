<!DOCTYPE html>
<html>
    <head>
	<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <title>Regular Season Championship</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Regular Season Championship" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="css/component.css" />
    </head>
    <body id="page">
        <div class="container">
            <!-- Top Bar -->
            <div class="rsc-top">
                <a href="http://cise.ufl.edu/class/cis4301sp14/assignments/extra_credit.md">
                    <strong>CIS4301</strong> Extra Credit
                </a>
                <span class="right">
                    <a href="mailto:cmetcalf@cise.ufl.edu" target="_blank">cmetcalf@cise.ufl.edu</a>
                    <a href="http://www.toprightpixel.com/">
                        <strong>Chelsea Metcalf</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div>
            <!--/ Top Bar -->
			<header>
				<h1>Regular <span>Season</span> Championship</h1>
				<h2>
                                    Definition: <a href="http://grantland.com/the-triangle/introducing-the-nba-regular-season-championship-belt/">regular season championship belt</a>
                                    <br>
                                    Data Source: <a href="http://www.landofbasketball.com/results/2013_2014_scores_full.htm">scores</a>
                                    <br>
                                    Download: <a href="https://www.dropbox.com/sh/lpm7ly9myesj9ay/KvYAdQHshG">code</a>
                                    <br><br>
                                    Specify a date range (yyyy-mm-dd) to see who was the regular season champion at that time.
                                </h2>
                                <br>
                                    <form action="Submit" method="post" style="display:inline">
                                        <h1>Start Date: &nbsp;</h1><input class="textbox" input type="text" name="startDate" value="2013-10-30" readonly><br><br>
                                        <h1>End Date: &nbsp;</h1><input class="textbox" input type="text" name="endDate"><br><br>
                                        <button class="btn btn-6 btn-6l">Submit</button>
                                    </form>
                                     <%
                                        if(request.getParameter("winner") != null)
                                        {
                                            out.println("<br><br><br>");
                                            out.println("<h1>Result</h1>");
                                            out.println("Current Regular Season Champ: " + request.getParameter("winner"));
                                            out.println("<br><br>Game Date: " + request.getParameter("gamedate"));
                                            out.println("<br><br>Requested Date: " + request.getParameter("requesteddate"));
                                            out.println("<br><br>");
                                        }
                                     %>
                        </header>
        </div>
    </body>
</html>