package com.epam.web.command;

import com.epam.Path;
import com.epam.dto.CrewParser;
import com.epam.entity.Crew;
import com.epam.dao.impl.MyCrewDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewCrew extends Command {
    private static final Logger LOG = Logger.getLogger(NewCrew.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        Crew c=newCrew(request);
        String result = new MyCrewDAO().validate(c, newCrewList(request), Integer.parseInt(request.getParameter("flightId")));
        if (!result.equals("OK")) {
            LOG.trace("Errors --> "+result);
            request.setAttribute("errors", result);
            return Path.CREW_THIS;
        }
        LOG.trace("Crew List -->"+newCrewList(request));
        LOG.debug("Command finished");

        return Path.CREW_RETURN_LIST;
    }

        List<Integer> newCrewList(HttpServletRequest request){
        List<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(request.getParameter("pilot")));
        list.add(Integer.valueOf(request.getParameter("navigator")));
        list.add(Integer.valueOf(request.getParameter("radio_operator")));
        list.add(Integer.valueOf(request.getParameter("fConductor")));
        list.add(Integer.valueOf(request.getParameter("sConductor")));
        return list;
    }

    Crew newCrew(HttpServletRequest request){
        MyCrewDAO dao = new MyCrewDAO();
        return dao.fillCrew(CrewParser.crewDTOParser(request));
    }
}
