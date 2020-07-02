import UsageEntryPage from "./../scenes/usage/UsageEntryPage";
import UsagePage from "../scenes/usage/UsagePage";
import UsageReportPage from "../scenes/usage/UsageReportPage";

const routes = [
  {
    path: "/",
    component: UsagePage,
  },
  {
    path: "/add",
    component: UsageEntryPage,
  },
  {
    path: "/report",
    component: UsageReportPage,
  },
];

export default routes;
