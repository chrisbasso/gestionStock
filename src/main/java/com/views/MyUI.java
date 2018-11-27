package com.views;

import javax.servlet.annotation.WebServlet;

import com.domain.Repuesto;
import com.services.RepuestoService;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;


import java.util.List;


@Theme("mytheme")
public class MyUI extends UI {

    private RepuestoService repuestoService = new RepuestoService();
    private Grid<Repuesto> grid = new Grid<>(Repuesto.class);
    private TextField buscador = new TextField();
    private VerticalLayout layout = new VerticalLayout();
    private HorizontalLayout titulo = new HorizontalLayout();
    private Button btnBuscar = new Button("Buscar");
    private Label tituloLabel = new Label("\"Repar-App Control de Stock\"");

    private HorizontalLayout hlButtons = new HorizontalLayout();

    private TextField cantidadField = new TextField("Cantidad");
    private TextField nombreField = new TextField(("Nombre"));
    private TextField idField = new TextField(("ID"));


    private Button btnComprar = new Button("Comprar");
    private Button btnVender = new Button("Vender");

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        titulo.addComponent(tituloLabel);
        hlButtons.addComponents(nombreField ,cantidadField, btnComprar, btnVender);

        tituloLabel.setSizeFull();

        layout.addComponents(titulo,new HorizontalLayout(buscador, btnBuscar), grid, hlButtons);

        updateList();

        nombreField.setWidth("400px");

        btnBuscar.addClickListener(e -> buscar());

        btnComprar.addClickListener(e -> comprar());

        btnVender.addClickListener(e -> vender());

        grid.addItemClickListener(e -> setCompCantidad(e.getItem().getNombre(), String.valueOf(e.getItem().getId())));

        grid.setWidth("1200px");

        grid.setColumnOrder("id","nombre", "marca", "modelo", "anio", "descripcion", "cantidad", "precio");

        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        hlButtons.setComponentAlignment(btnComprar, Alignment.BOTTOM_LEFT);
        hlButtons.setComponentAlignment(btnVender, Alignment.BOTTOM_LEFT);

        nombreField.setEnabled(false);

        setContent(layout);

    }

    public void comprar(){
        repuestoService.updateCantidad(Long.parseLong(idField.getValue()), Integer.parseInt(cantidadField.getValue()));
        updateList();
    }

    public void vender(){
        repuestoService.updateCantidad(Long.parseLong(idField.getValue()), -(Integer.parseInt(cantidadField.getValue())));
        updateList();
    }

    public void setCompCantidad(String nombre, String id){

        this.idField.setValue(id);
        this.nombreField.setValue(nombre);

    }

    public void buscar(){
        List<Repuesto> repuestos = repuestoService.getRepuestos(buscador.getValue());
        grid.setItems(repuestos);
    }

    public void updateList() {

        List<Repuesto> repuestos = repuestoService.getRepuestos();
        grid.setItems(repuestos);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
